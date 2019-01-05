/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.park.dao.custom.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import lk.ijse.park.dao.CrudUtil;
import lk.ijse.park.dao.custom.TicketDAO;
import lk.ijse.park.entity.Ticket;

public class TicketDAOImpl implements TicketDAO {

    @Override
    public boolean save(Ticket entity) throws Exception {
        return CrudUtil.executeUpdate("INSERT INTO Ticket VALUES (?,?,?,?,?,?,?,?,?,?)", entity.gettID(), entity.getrID(), entity.getPsID(), entity.getPaID(), entity.getCheck_In_Time(), entity.getCheck_In_Date(), entity.getCustomer_Name(), entity.getPhone_Number(), entity.getCheck_Out_Time(), entity.getCheck_Out_Date()) > 0;
    }

    @Override
    public boolean update(Ticket entity) throws Exception {
        return CrudUtil.executeUpdate("UPDATE Ticket SET rID=?, PsID=?, PaID=? , Check_In_Time=? , Check_In_Date=? , Customer_Name=? ,Phone_Number=? , Check_Out_Time=?, Check_Out_Date=? WHERE tID=?",
                entity.getrID(),
                entity.getPsID(),
                entity.getPaID(),
                entity.getCheck_In_Time(),
                entity.getCheck_In_Date(),
                entity.getCustomer_Name(),
                entity.getPhone_Number(),
                entity.getCheck_Out_Time(),
                entity.getCheck_Out_Date(),
                entity.gettID()
        ) > 0;
    }

    @Override
    public boolean delete(String id) throws Exception {
        return CrudUtil.executeUpdate("DELETE From Ticket where tID=(?)", id) > 0;
    }

    @Override
    public Ticket search(String id) throws Exception {
        ResultSet rst = CrudUtil.executeQuery("Select * From Ticket where tID=(?)", id);
        if (rst.next()) {
            return new Ticket(rst.getString("tID"), rst.getString("rID"), rst.getString("psID"), rst.getString("paID"), rst.getString("check_In_Time"), rst.getString("check_In_Date"), rst.getString("customer_Name"), rst.getString("phone_Number"), rst.getString("check_Out_Time"), rst.getString("check_Out_Date")
            );
        } else {
            return null;
        }
    }

    @Override
    public ArrayList<Ticket> getAll() throws Exception {
        ArrayList<Ticket> alTicket = new ArrayList<>();
        ResultSet rst = CrudUtil.executeQuery("SELECT * FROM Ticket ");
        while (rst.next()) {
            alTicket.add(new Ticket(rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4),
                    rst.getString(5),
                    rst.getString(6),
                    rst.getString(7),
                    rst.getString(8),
                    rst.getString(9),
                    rst.getString(10)));
        }
        return alTicket;
    }

}
