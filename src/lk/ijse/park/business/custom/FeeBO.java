/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.park.business.custom;

import java.util.ArrayList;
import lk.ijse.park.business.SuperBO;
import lk.ijse.park.model.FeeDTO;

/**
 *
 * @author asitha
 */
public interface FeeBO extends SuperBO{
    public boolean addFee(FeeDTO fee) throws Exception;

    public boolean deleteFee(String feeId) throws Exception;

    public boolean updateFee(FeeDTO fee) throws Exception;

    public FeeDTO searchFee(String FeeId) throws Exception;

    public ArrayList<FeeDTO> getAllFee() throws Exception;

    public ArrayList<String> getAllFeeIds() throws Exception;
}
