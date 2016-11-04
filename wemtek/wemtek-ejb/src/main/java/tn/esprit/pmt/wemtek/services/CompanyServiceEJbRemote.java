package tn.esprit.pmt.wemtek.services;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.pmt.wemtek.persistence.Company;

@Remote
public interface CompanyServiceEJbRemote {
	public List<Company> getAllCompany();
	public String addCompany(Company c) ; 
	public String deleteCompany(int id) ; 
	public String updateCompany(Company c) ; 
	public Company getCompanyById(int id) ; 

}
