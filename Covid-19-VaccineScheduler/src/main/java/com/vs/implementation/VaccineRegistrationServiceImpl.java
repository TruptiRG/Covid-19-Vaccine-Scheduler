package com.vs.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.vs.exception.VaccineRegistrationException;
import com.vs.model.Member;
import com.vs.model.VaccineRegistration;
import com.vs.repo.VaccineRegistrationRepo;
import com.vs.service.VaccineRegistrationService;

public class VaccineRegistrationServiceImpl implements VaccineRegistrationService{
	
	@Autowired
	private VaccineRegistrationRepo vaccineRegistrationRepo;

	@Override
	public List<VaccineRegistration> getVaccineRegistration(Long moblieno) throws VaccineRegistrationException {
		
		List<VaccineRegistration> vaccineRegistration = vaccineRegistrationRepo.findByMobileno(moblieno);
		if(vaccineRegistration.size() > 0) {
			return vaccineRegistration;
		}else {
			throw new VaccineRegistrationException("No VaccineRegistration found...");
		}
		
	}

	@Override
	public List<Member> getAllMember(Long mobileno) throws VaccineRegistrationException {
		
		
		return null;
	}

	@Override
	public VaccineRegistration addVaccineRegistration(VaccineRegistration regs) throws VaccineRegistrationException {
		
		return null;
	}

	@Override
	public VaccineRegistration updateVaccineRegistration(VaccineRegistration regs) throws VaccineRegistrationException {
		
		Optional<VaccineRegistration> opt = vaccineRegistrationRepo.findById(regs.getRegistrationNo());
		if(opt.isPresent()) {
			VaccineRegistration updatedVaccineRegs = vaccineRegistrationRepo.save(regs);
			return updatedVaccineRegs;
		}else {
			throw new VaccineRegistrationException("Invalid VaccineRegistration");
		}
		
	}

	@Override
	public boolean deleteVaccineRegistration(VaccineRegistration regs) throws VaccineRegistrationException {
		Optional<VaccineRegistration> opt = vaccineRegistrationRepo.findById(regs.getRegistrationNo());
		if(opt.isPresent()) {
			throw new RuntimeException("not able to access");
		}
		
		VaccineRegistration vaccineRegestration = vaccineRegistrationRepo.findById(regs.getRegistrationNo())
													.orElseThrow(()->new VaccineRegistrationException("Vaccine Registration not Found"));
		vaccineRegistrationRepo.delete(vaccineRegestration);
		return true;
	}

}
