/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.park.business.custom;

import java.util.ArrayList;
import lk.ijse.park.business.SuperBO;
import lk.ijse.park.entity.Payment;
import lk.ijse.park.model.PaymentDTO;

/**
 *
 * @author asitha
 */
public interface PaymentBO extends SuperBO{
    
    public boolean addPayment(PaymentDTO payment) throws Exception;

    public boolean deletePayment(String PaymentId) throws Exception;

    public boolean updatePayment(Payment payment) throws Exception;

    public PaymentDTO searchPayment(String PaymentId) throws Exception;

    public ArrayList<PaymentDTO> getAllPayment() throws Exception;

    public ArrayList<String> getAllPaymentIds() throws Exception;
}
