package org.mgpravia.api;

import org.mgpravia.api.TransfersApi;
import org.mgpravia.model.*;

import java.time.OffsetDateTime;

public class ContactTransferApi implements TransfersApi{
    /**
     * Ejecuta la transferencia previamente validada.
     *
     * @param transferExecutionRequest
     * @return Transferencia realizada exitosamente
     * @return Solicitud inválida
     * @return La transferencia ya fue procesada
     */
    @Override
    public TransferExecutionResponse executeTransfer(TransferExecutionRequest transferExecutionRequest) {

        System.out.println("Start execute transfer");
        TransferExecutionResponse  transferExecutionResponse = new TransferExecutionResponse();
        transferExecutionResponse.setTransactionId("TRX-987654321");
        transferExecutionResponse.setStatus(TransferExecutionResponse.StatusEnum.SUCCESS);
        transferExecutionResponse.setSourceAccount("001123456789");
        transferExecutionResponse.setDestinationPhoneNumber("987654321");
        transferExecutionResponse.setAmount(45.00);
        transferExecutionResponse.currency("PEN");
        transferExecutionResponse.setTransactionDateTime(OffsetDateTime.now());
        return null;
    }

    /**
     * Verifica que el número de celular exista y se encuentre activo para recibir transferencias.
     *
     * @param phoneNumber Número celular destino
     * @return Número validado correctamente
     * @return Número no encontrado
     * @return Número inactivo
     */
    @Override
    public ProductValidationResponse validateDestinationContact(String phoneNumber) {
        System.out.println("Start validate transfer");
        ProductValidationResponse  productValidationResponse = new ProductValidationResponse();
        productValidationResponse.setActive(true);
        productValidationResponse.setCustomerId("CUS123456");
        productValidationResponse.setCustomerName("Juan Perez");
        productValidationResponse.setPhoneNumber(phoneNumber);
        return productValidationResponse;
    }

    /**
     * Valida autenticación, saldo disponible y reglas de negocio antes de ejecutar la transferencia.
     *
     * @param transferVerificationRequest
     * @return Transferencia válida para ejecución
     * @return Usuario no autenticado
     * @return Saldo insuficiente o regla de negocio incumplida
     */
    @Override
    public TransferVerificationResponse verifyTransfer(TransferVerificationRequest transferVerificationRequest) {

        System.out.println("Start verify transfer");
        TransferVerificationResponse transferVerificationResponse = new TransferVerificationResponse();
        transferVerificationResponse.setTransferAllowed(true);
        transferVerificationResponse.setVerificationId("VER-202506170001");
        transferVerificationResponse.setAuthenticated(true);
        transferVerificationResponse.setSufficientBalance(true);
        transferVerificationResponse.setAvailableBalance(2000.00);
        transferVerificationResponse.setExpirationDateTime(OffsetDateTime.now());
        return transferVerificationResponse;
    }
}
