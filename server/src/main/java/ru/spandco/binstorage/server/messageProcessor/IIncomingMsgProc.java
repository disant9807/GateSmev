package ru.spandco.binstorage.server.messageProcessor;

import ru.spandco.binstorage.server.model.IncomingSmevRequest;
import ru.spandco.binstorage.server.model.IncomingSmevResponse;

//Обработчик сообщений из входящих очередей СМЭВ
public interface IIncomingMsgProc {
    public boolean ProcessRequest(IncomingSmevRequest smevRequest);

    public boolean ProcessResponse (IncomingSmevResponse smevMessage);
}
