package com.nt.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.jta.JtaTransactionManager;

import com.atomikos.icatch.jta.UserTransactionImp;
import com.atomikos.icatch.jta.UserTransactionManager;

@Configuration
public class AOPConfig {

	@Bean(name = "aksDTxService")
	public UserTransactionImp createAksDTxService() {
		return new UserTransactionImp();
	}
	
	@Bean(name = "aksDTxMgmr")
	public UserTransactionManager createAksDTxMgmr() {
		return new UserTransactionManager();
	}
	
	@Bean(name = "jtaTxMgmr")
	public JtaTransactionManager createJTAMgmr() {
		JtaTransactionManager mgmr = new JtaTransactionManager();
		mgmr.setUserTransaction(createAksDTxService());
		mgmr.setTransactionManager(createAksDTxMgmr());
		return mgmr;
	}
}
