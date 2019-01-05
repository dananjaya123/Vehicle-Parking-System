/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.park.business.custom.impl;

import java.util.ArrayList;
import lk.ijse.park.business.custom.PaymentBO;
import lk.ijse.park.dao.DAOFactory;
import lk.ijse.park.dao.custom.PaymentDAO;
import lk.ijse.park.entity.Payment;
import lk.ijse.park.model.PaymentDTO;


public class PaymentBOImpl implements PaymentBO {

    private final PaymentDAO paymentDAO;
   
    public PaymentBOImpl(){
        this.paymentDAO = DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.PAYMENENT);
    }
    
    @Override
    public boolean addPayment(PaymentDTO payment) throws Exception {
        return paymentDAO.save(new Payment(payment.getpID(),payment.getPtID(),payment.getDate(),payment.getAmount()));
    }

    @Override
    public boolean deletePayment(String PaymentId) throws Exception {
        return paymentDAO.delete(PaymentId);
    }

    @Override
    public boolean updatePayment(Payment payment) throws Exception {
        return paymentDAO.update(new Payment(payment.getpID(),payment.getPtID(),payment.getDate(),payment.getAmount()));
    }

    @Override
    public PaymentDTO searchPayment(String PaymentId) throws Exception {
        Payment search = paymentDAO.search(PaymentId);
         return new PaymentDTO(search.getpID(),search.getPtID(),search.getDate(),search.getAmount());
    }

    @Override
    public ArrayList<PaymentDTO> getAllPayment() throws Exception {
        ArrayList<Payment> fee = paymentDAO.getAll();
        ArrayList<PaymentDTO> dtos = new ArrayList<>();
        fee.stream().forEach((e) -> {
            dtos.add(new PaymentDTO(e.getpID(),e.getPtID(),e.getDate(),e.getAmount()));
        });
        return dtos;
    }

    @Override
    public ArrayList<String> getAllPaymentIds() throws Exception {
        ArrayList<Payment> all = paymentDAO.getAll();
        ArrayList<String> allIds = new ArrayList<>();
        for (Payment fee : all) {
            allIds.add(fee.getpID());
        }
        return allIds;
    }
    
}
