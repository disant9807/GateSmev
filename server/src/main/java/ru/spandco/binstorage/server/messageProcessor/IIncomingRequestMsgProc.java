package ru.spandco.binstorage.server.messageProcessor;

import ru.spandco.binstorage.server.model.IncomingSmevRequest;
import ru.spandco.binstorage.server.model.IncomingSmevResponse;

// Обработать входящий запрос СМЭВ
public interface IIncomingRequestMsgProc {
    public boolean ProcessRequest(IncomingSmevRequest smevRequest);
}
