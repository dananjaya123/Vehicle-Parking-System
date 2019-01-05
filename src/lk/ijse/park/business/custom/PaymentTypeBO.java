/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.park.business.custom;

import java.util.ArrayList;
import lk.ijse.park.business.SuperBO;
import lk.ijse.park.model.PaymentTypeDTO;

/**
 *
 * @author asitha
 */
public interface PaymentTypeBO extends SuperBO{
    
    public boolean addPaymentType(PaymentTypeDTO paymentType) throws Exception;

    public boolean deletePaymentType(String paymentTypeId) throws Exception;

    public boolean updatePaymentType(PaymentTypeDTO paymentType) throws Exception;

    public PaymentTypeDTO searchCustomer(String paymentTypeId) throws Exception;

    public ArrayList<PaymentTypeDTO> getAllPaymentTypes() throws Exception;

    public ArrayList<String> getAllPaymentType() throws Exception;
}
