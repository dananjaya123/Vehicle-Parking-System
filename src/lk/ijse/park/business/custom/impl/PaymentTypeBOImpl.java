/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.park.business.custom.impl;

import java.util.ArrayList;
import lk.ijse.park.business.custom.PaymentTypeBO;
import lk.ijse.park.dao.DAOFactory;
import lk.ijse.park.dao.custom.PaymentTypeDAO;
import lk.ijse.park.entity.PaymentType;
import lk.ijse.park.model.PaymentTypeDTO;


public class PaymentTypeBOImpl implements PaymentTypeBO {

    private final PaymentTypeDAO paymentTypeDAO;
   
    public PaymentTypeBOImpl(){
        this.paymentTypeDAO = DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.PAYMENTTYPE);
    }
    
    @Override
    public boolean addPaymentType(PaymentTypeDTO paymentType) throws Exception {
        return paymentTypeDAO.save(new PaymentType(paymentType.getPtID(),paymentType.getPayment_Tyep()));
    }

    @Override
    public boolean deletePaymentType(String paymentTypeId) throws Exception {
        return paymentTypeDAO.delete(paymentTypeId);
    }

    @Override
    public boolean updatePaymentType(PaymentTypeDTO paymentType) throws Exception {
        return paymentTypeDAO.update(new PaymentType(paymentType.getPtID(),paymentType.getPayment_Tyep()));
    }

    @Override
    public PaymentTypeDTO searchCustomer(String paymentTypeId) throws Exception {
         PaymentType search = paymentTypeDAO.search(paymentTypeId);
         return new PaymentTypeDTO(search.getPtID(),search.getPayment_Tyep());
    }

    @Override
    public ArrayList<PaymentTypeDTO> getAllPaymentTypes() throws Exception {
        ArrayList<PaymentType> fee = paymentTypeDAO.getAll();
        ArrayList<PaymentTypeDTO> dtos = new ArrayList<>();
        fee.stream().forEach((e) -> {
            dtos.add(new PaymentTypeDTO(e.getPtID(),e.getPayment_Tyep()));
        });
        return dtos;
    }

    @Override
    public ArrayList<String> getAllPaymentType() throws Exception {
        ArrayList<PaymentType> all = paymentTypeDAO.getAll();
        ArrayList<String> allIds = new ArrayList<>();
        for (PaymentType fee : all) {
            allIds.add(fee.getPtID());
        }
        return allIds;
    }
    
}
