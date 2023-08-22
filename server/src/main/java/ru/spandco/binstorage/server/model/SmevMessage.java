package ru.spandco.binstorage.server.model;

import org.w3c.dom.Element;

import java.util.Date;

public class SmevMessage {
    public String Id;
    public Element Content;
    public boolean IsTest;
    public String TransactionCode;
    public String ReferenceMessageId;
    public Date EndOfLife;
    public String[] AttachmentIds;
}
