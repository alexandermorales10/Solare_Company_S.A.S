package com.MoralexCorpSolare_Company_SAS.payment.service;

import com.MoralexCorpSolare_Company_SAS.payment.dto.PaymentRequestDTO;
import com.MoralexCorpSolare_Company_SAS.payment.dto.PaymentResponseDTO;
import com.MoralexCorpSolare_Company_SAS.payment.dto.WebhookDTO;

public interface PaymentService {

    PaymentResponseDTO createPayment(PaymentRequestDTO requestDTO);

    void handleWebhook(WebhookDTO webhookDTO);
}
