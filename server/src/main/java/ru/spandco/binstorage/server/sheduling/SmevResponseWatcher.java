package ru.spandco.binstorage.server.sheduling;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import ru.spandco.binstorage.server.messageProcessor.IIncomingMsgProc;
import ru.spandco.binstorage.server.model.GetRequestRequest;
import ru.spandco.binstorage.server.model.GetRequestResponse;
import ru.spandco.binstorage.server.model.IncomingSmevRequest;
import ru.spandco.binstorage.server.recivers.ISmevReciver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

@Component
public class SmevResponseWatcher {

    private ISmevReciver reciver;

    private IIncomingMsgProc messageProcessor;

    @Scheduled(fixedDelay = 2000)
    public void TransactionCheckedStart() throws InterruptedException {
        //Проверка очереди запросов СМЭВ
        GetRequestResponse response =  reciver.GetRequestAsync(BuildGetRequestRequestMessage());

        // Request smevRequest = response?.RequestMessage?.Items?.OfType<Schema11.Request>()?.SingleOrDefault();
        // if (smevRequest == null) { очередь запросов пуста  }

        // Сохраняем входящий запрос в базу + сохраняем вложения запроса через сервис binaryStorage.
        // Сохраняем вложения с таймером автоматического удаления через 2 секунды.
        IncomingSmevRequest request = reciver.SaveSmevMessageReq(response);

        //Подтверждаем вложения что-бы они не удалились т.к. запрос успешно сохранился.
        reciver.ConfirmAttachments(request.AttachmentIds);

        // Обработка входящего запроса смэв в соответствующем ему обработчике
        boolean hasProcessed = messageProcessor.ProcessRequest(request);
        if (hasProcessed) {
            // если обработка прошла успешно, то отправляем в смэв подтверждение о том, что успешно приняли входящий запрос
            reciver.Acknowledge(request.Id, null);
        }
    }

    private static GetRequestResponse BuildGetRequestRequestMessage() {
        return new GetRequestResponse();
    }
}
