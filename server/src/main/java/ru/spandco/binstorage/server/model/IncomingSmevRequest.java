package ru.spandco.binstorage.server.model;

import org.w3c.dom.Element;

import java.util.Date;

public class IncomingSmevRequest extends SmevMessage {
    public String CorellationId;
    public String SenderCode;
    public String SenderName;
    public Date Sent;
}
