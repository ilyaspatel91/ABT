package com.gkaakash.controller;

import java.util.ArrayList;

import org.xmlrpc.android.XMLRPCException;
import org.xmlrpc.android.XMLRPCFault;

import android.R.string;

import com.gkaakash.coreconnection.CoreConnection;

public class Report {
	private CoreConnection conn;
	private Object[] trialResult;
	private Object[] ledgerResult;
	private Object[] grosstrialResult;
	private Object[] extendedtrialResult;
	private Object[] projectStatement;
	private Object[] profitLossStatement;
	private Object[] cashFlowStatement;
	private Object[] getBalancesheetDisplay;
	private Object[] getLedgerForBankRecon;
	private String setBankReconciliationResult,rollover;
	private Boolean result;
	private Object[] calculateBalance;
	
	/***
	 * Default constructor
	 * create instance of CoreConnection() to get connection with server
	 */ 
	public Report() {
		conn = new CoreConnection();
	}
	
	/*
	 * get trial balance
	 */ 
	public Object getTrialBalance(Object[] params,Object client_id) {
		
		try {
			trialResult = (Object[])conn.getClient().call("reports.getTrialBalance",params,client_id);
			
		} catch (XMLRPCFault e) {
			try {
				trialResult = (Object[])conn.getClient().call("reports.getTrialBalance",params,client_id);
			} catch (XMLRPCException e1) {
			
				e1.printStackTrace();
			}
		}
		catch (Exception e) { 
			
			e.printStackTrace();
		} 
		return trialResult;
	}
	 
	public Object getLedger(Object[] params,Object client_id) {
		
		try {
			System.out.println(client_id);
			System.out.println("we are in ledger");
			System.out.println(params);
			ledgerResult = (Object[])conn.getClient().call("reports.getLedger",params,client_id);
			System.out.println(ledgerResult);
		} catch (XMLRPCFault e) {
			try {
				ledgerResult = (Object[])conn.getClient().call("reports.getLedger",params,client_id);
			} catch (XMLRPCException e1) {
				
				e1.printStackTrace();
			}
		}catch (Exception e) {
			
		}
		
		return ledgerResult;
	}
public Object getGrossTrialBalance(Object[] params,Object client_id) {
		
		try {
			System.out.println(client_id);
			System.out.println("we are in gross trial");
			System.out.println(params);
			grosstrialResult = (Object[])conn.getClient().call("reports.getGrossTrialBalance",params,client_id);
			
		} catch (XMLRPCFault e) {
			try {
				grosstrialResult = (Object[])conn.getClient().call("reports.getGrossTrialBalance",params,client_id);
			} catch (XMLRPCException e1) {
			
				e1.printStackTrace(); 
			}
		}
		catch (Exception e) { 
			
			e.printStackTrace(); 
		} 
		return grosstrialResult;
	}
	public Object getExtendedTrialBalance(Object[] params,Object client_id) {
		
		try {
			System.out.println(client_id);
			System.out.println("we are in extendedtrial");
			System.out.println(params);
			extendedtrialResult = (Object[])conn.getClient().call("reports.getExtendedTrialBalance",params,client_id);
			
		} catch (XMLRPCFault e) {
			try {
				extendedtrialResult = (Object[])conn.getClient().call("reports.getExtendedTrialBalance",params,client_id);
			} catch (XMLRPCException e1) {
			
				e1.printStackTrace(); 
			}
		}
		catch (Exception e) { 
			
			e.printStackTrace();
		} 
		return extendedtrialResult;
	}

	
	/*
	 * get project statement report
	 */ 
	public Object getProjectStatementReport(Object[] params,Object client_id) {
		
		try {
			projectStatement = (Object[])conn.getClient().call("reports.getProjectStatementReport",params,client_id);
		} catch (XMLRPCException e1) {
		
			e1.printStackTrace();
		}
		
		catch (Exception e) { 
			
			e.printStackTrace();
		} 
		return projectStatement;
	}
	
	/*
	 * get Income and Expenditure/Profit and Loss report
	 */ 
	public Object getProfitLossDisplay(Object[] params,Object client_id) {
		
		try { 
			profitLossStatement = (Object[])conn.getClient().call("reports.getProfitLossDisplay",params,client_id);
		} catch (XMLRPCException e1) {
		
			e1.printStackTrace();
		}
		
		catch (Exception e) { 
			
			e.printStackTrace();
		} 
		return profitLossStatement;
	}
	
	/*
	 * get cash flow report
	 */ 
	public Object getCashFlow(Object[] params,Object client_id) {
		
		try { 
			cashFlowStatement = (Object[])conn.getClient().call("reports.getCashFlow",params,client_id);
		} catch (XMLRPCException e1) {
		
			e1.printStackTrace();
		}
		
		catch (Exception e) { 
			
			e.printStackTrace();
		} 
		return cashFlowStatement;
	}
	/***
	 * It will give balance sheet report grid with the front-end 
	 * display sequence 1st coloum , 2nd coloum  and headers values
	 * We can also call getBalancesheetReport contain values to 
	 * be displayed  
	 * @param params list
	 * contains financialyear_from, report_fromdate,report_todate,
	 * report_type, org_type,balancesheet_type
	 * @param client_id
	 * @return list of list 
	 */
	public Object getBalancesheetDisplay(Object[] params,Object client_id) {
		
		try {
			getBalancesheetDisplay = (Object[])conn.getClient().call("reports.getBalancesheetDisplay",params,client_id);
			System.out.println("getBalancesheetDisplay :"+getBalancesheetDisplay);
		} 
		catch (XMLRPCException e1) {
		
			e1.printStackTrace();
		}
		
		return getBalancesheetDisplay;
	}
	
	
	/*
	 * get all cleared and uncleared transactions for bank recon
	 * depending upon clear flag
	 */
	public Object getLedgerForBankRecon(Object[] params,Object[] flag, Integer client_id) {
		try {
			
			getLedgerForBankRecon = (Object[])conn.getClient().call("reports.updateBankRecon",params,flag, client_id);
			
		} catch (XMLRPCFault e1) {
			
			e1.printStackTrace();
			
		}catch (Exception e) {
			
			e.printStackTrace();
		}
		
		return getLedgerForBankRecon;
	}
	
	/*
	 * pass the list of all rows to be clear
	 */
	public String setBankReconciliation(ArrayList<ArrayList> list, Integer client_id) {
		try {
			setBankReconciliationResult = (String) conn.getClient().call("reports.setBankReconciliation", list, client_id);
			
		} catch (XMLRPCFault e1) {
			
			e1.printStackTrace();
			
		}catch (Exception e) {
			
			e.printStackTrace();
		}
		
		return setBankReconciliationResult;
	}
	
	/*
	 * uncleare the cleared transactions
	 */
	public Boolean deleteClearedRecon(ArrayList<String> list, Integer client_id) {
		try {
			result = (Boolean) conn.getClient().call("reports.deleteClearedRecon", list, client_id);
			
		} catch (XMLRPCFault e1) {
			
			e1.printStackTrace();
			
		}catch (Exception e) {
			
			e.printStackTrace();
		}
		
		return result;
	}
	
	
	public Object calculateBalance(Object[] params,Object client_id) {
		
		try { 
			
			 System.out.println("data:"+params[0]+""+params[1]+""+params[2]+""+params[3]);
			System.out.println("nnn:"+client_id);
			calculateBalance = (Object[])conn.getClient().call("reports.calculateBalance",params,client_id);
			
		} catch (XMLRPCException e) {
			
			e.printStackTrace();
		} 
		return calculateBalance;
	}
	
	public String rollOver(Object[] params,Object client_id) {
		
		try { 
			
			System.out.println("data:"+params[0]+""+params[1]+""+params[2]+""+params[3]);
			rollover = (String) conn.getClient().call("rollover",params,client_id);
			//System.out.println("data:"+params[0]+""+params[1]+""+params[2]+""+params[3]);
			System.out.println("nnn:"+rollover);
		} catch (XMLRPCException e) {
			System.out.println("nnn:"+rollover);
			e.printStackTrace();
		}
		return rollover;
	}
}
