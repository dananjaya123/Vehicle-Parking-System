/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.park.business.custom;

import java.util.ArrayList;
import lk.ijse.park.business.SuperBO;
import lk.ijse.park.model.TicketDTO;

/**
 *
 * @author asitha
 */
public interface TicketBO extends SuperBO {
   
    public boolean addTicket(TicketDTO ticket) throws Exception;

    public boolean deleteTicket(String ticketId) throws Exception;

    public boolean updateTicket(TicketDTO ticket) throws Exception;

    public TicketDTO searchTicket(String ticketId) throws Exception;

    public ArrayList<TicketDTO> getAllTicket() throws Exception;

    public ArrayList<String> getAllTicketIds() throws Exception;
}
