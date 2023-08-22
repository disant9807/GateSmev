package ru.spandco.binstorage.server.controllers;

import ru.spandco.binstorage.server.model.SmevMessage;
import ru.spandco.binstorage.server.model.SmevStatus;

public class GateController {

    // Отправить запрос СМЭВ
    public String SendRequest(SmevMessage message, String contragentId) {
        throw new RuntimeException();
    }

    // Отправить ответ на запрос СМЭВ
    public String SendResponse(SmevMessage message) {
        throw new RuntimeException();
    }

    // Отправить в СМЭВ статус обработки сообщения
    public String SendStatus(SmevStatus status) {
        throw new RuntimeException();
    }
}
