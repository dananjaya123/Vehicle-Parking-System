/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.park.business.custom.impl;

import java.util.ArrayList;
import lk.ijse.park.business.custom.TicketBO;
import lk.ijse.park.dao.DAOFactory;
import lk.ijse.park.dao.custom.TicketDAO;
import lk.ijse.park.entity.Ticket;
import lk.ijse.park.model.TicketDTO;


public class TicketBOImpl implements TicketBO {
    
    private final TicketDAO ticketDAO;
   
   public TicketBOImpl(){
        this.ticketDAO = DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.TICKET);
    }
    @Override
    public boolean addTicket(TicketDTO ticket) throws Exception {
        return ticketDAO.save(new Ticket(ticket.gettID(),ticket.getrID(),ticket.getPsID(),ticket.getPaID(),ticket.getCheck_In_Time(),ticket.getCheck_In_Date(),ticket.getCustomer_Name(),ticket.getPhone_Number(),ticket.getCheck_Out_Time(),ticket.getCheck_Out_Date()));
    }

    @Override
    public boolean deleteTicket(String ticketId) throws Exception {
        return ticketDAO.delete(ticketId);
    }

    @Override
    public boolean updateTicket(TicketDTO ticket) throws Exception {
        return ticketDAO.update(new Ticket(ticket.gettID(),ticket.getrID(),ticket.getPsID(),ticket.getPaID(),ticket.getCheck_In_Time(),ticket.getCheck_In_Date(),ticket.getCustomer_Name(),ticket.getPhone_Number(),ticket.getCheck_Out_Time(),ticket.getCheck_Out_Date()));
    }

    @Override
    public TicketDTO searchTicket(String ticketId) throws Exception {
         Ticket search = ticketDAO.search(ticketId);
         return new TicketDTO(search.gettID(),search.getrID(),search.getPsID(),search.getPaID(),search.getCheck_In_Time(),search.getCheck_In_Date(),search.getCustomer_Name(),search.getPhone_Number(),search.getCheck_Out_Time(),search.getCheck_Out_Date());
    }

    @Override
    public ArrayList<TicketDTO> getAllTicket() throws Exception {
        ArrayList<Ticket> fee = ticketDAO.getAll();
        ArrayList<TicketDTO> dtos = new ArrayList<>();
        fee.stream().forEach((e) -> {
            dtos.add(new TicketDTO(e.gettID(),e.getrID(),e.getPsID(),e.getPaID(),e.getCheck_In_Time(),e.getCheck_In_Date(),e.getCustomer_Name(),e.getPhone_Number(),e.getCheck_Out_Time(),e.getCheck_Out_Date()));
        });
        return dtos;
    }

    @Override
    public ArrayList<String> getAllTicketIds() throws Exception {
            ArrayList<Ticket> all = ticketDAO.getAll();
        ArrayList<String> allIds = new ArrayList<>();
        for (Ticket fee : all) {
            allIds.add(fee.gettID());
        }
        return allIds;
    }
}
