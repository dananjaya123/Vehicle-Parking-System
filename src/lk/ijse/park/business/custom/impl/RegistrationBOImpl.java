/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.park.business.custom.impl;

import java.util.ArrayList;
import lk.ijse.park.business.custom.RegistrationBO;
import lk.ijse.park.dao.DAOFactory;
import lk.ijse.park.dao.custom.RegistrationDAO;
import lk.ijse.park.entity.Registration;
import lk.ijse.park.model.RegistrationDTO;

public class RegistrationBOImpl implements RegistrationBO {

    private final RegistrationDAO registrationDAO;

    public RegistrationBOImpl() {
        this.registrationDAO = DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.REGISTRATION);
    }

    @Override
    public boolean addRegistration(RegistrationDTO registration) throws Exception {
        return registrationDAO.save(new Registration(registration.getrID(), registration.getvID(), registration.getNic(), registration.getDate()));
    }

    @Override
    public boolean deleteRegistration(String registrationId) throws Exception {
        return registrationDAO.delete(registrationId);
    }

    @Override
    public boolean updateRegistration(RegistrationDTO registration) throws Exception {
        return registrationDAO.update(new Registration(registration.getrID(), registration.getvID(), registration.getNic(), registration.getDate()));
    }

    @Override
    public RegistrationDTO searchRegistration(String registrationId) throws Exception {
        Registration search = registrationDAO.search(registrationId);
        return new RegistrationDTO(search.getrID(), search.getvID(), search.getNic(), search.getDate());
    }

    @Override
    public ArrayList<RegistrationDTO> getAllRegistration() throws Exception {
        ArrayList<Registration> fee = registrationDAO.getAll();
        ArrayList<RegistrationDTO> dtos = new ArrayList<>();
        fee.stream().forEach((e) -> {
            dtos.add(new RegistrationDTO(e.getrID(), e.getvID(), e.getNic(), e.getDate()));
        });
        return dtos;
    }

    @Override
    public ArrayList<String> getAllRegistrationIds() throws Exception {
        ArrayList<Registration> all = registrationDAO.getAll();
        ArrayList<String> allIds = new ArrayList<>();
        for (Registration fee : all) {
            allIds.add(fee.getrID());
        }
        return allIds;
    }

}
