package ru.spandco.binstorage.server.recivers;

import ru.spandco.binstorage.server.model.*;

public interface ISmevReciver<RQR, RR> {
    public void Acknowledge(String messageId, String originalId);
    public void ConfirmAttachments(String[] attachmentIds);

    public IncomingSmevRequest SaveSmevMessageReq(RQR requestResponse);

    public IncomingSmevResponse SaveSmevMessageRes(RR responseResponse);

    public SmevStatus TryGetExistingStatus(String messageId);

    public GetRequestResponse GetRequestAsync(GetRequestResponse requestRequest);
    public GetResponseResponse GetResponseRequest(GetResponseRequest responseRequest);
}
