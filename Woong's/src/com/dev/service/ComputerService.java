package com.dev.service;

import com.dev.dao.ComputerDAO;
import com.dev.vo.ComputerVO;
import com.dev.vo.GameVO;

import java.util.ArrayList;

public class ComputerService {
	
		private static ComputerService service = new ComputerService();
		public ComputerDAO dao = ComputerDAO.getInstance();
		
		private ComputerService() {}
		public static ComputerService getInstance() {
			return service;
		}
		
		public ArrayList<ComputerVO> mincpu(ComputerVO member) {
			ArrayList<ComputerVO> list = dao.mincpu(member);
			return list;
		}
		public ArrayList<ComputerVO> minram(ComputerVO member) {
			ArrayList<ComputerVO> list = dao.minram(member);
			return list;
		}
		public ArrayList<ComputerVO> mingpu(ComputerVO member) {
			ArrayList<ComputerVO> list = dao.mingpu(member);
			return list;
		}
		public ArrayList<ComputerVO> reccpu(ComputerVO member) {
			ArrayList<ComputerVO> list = dao.reccpu(member);
			return list;
		}
		public ArrayList<ComputerVO> recram(ComputerVO member) {
			ArrayList<ComputerVO> list = dao.recram(member);
			return list;
		}
		public ArrayList<ComputerVO> recgpu(ComputerVO member) {
			ArrayList<ComputerVO> list = dao.recgpu(member);
			return list;
		}
		public ArrayList<ComputerVO> mincase(ComputerVO member) {
			ArrayList<ComputerVO> list = dao.mincase(member);
			return list;
		}
		public ArrayList<ComputerVO> minhdd(ComputerVO member) {
			ArrayList<ComputerVO> list = dao.minhdd(member);
			return list;
		}
		public ArrayList<ComputerVO> minssd(ComputerVO member) {
			ArrayList<ComputerVO> list = dao.minssd(member);
			return list;
		}
		public ArrayList<ComputerVO> minmb(ComputerVO member) {
			ArrayList<ComputerVO> list = dao.minmb(member);
			return list;
		}
		public ArrayList<ComputerVO> minpower(ComputerVO member) {
			ArrayList<ComputerVO> list = dao.minpower(member);
			return list;
		}
		
		
		
		public ArrayList<ComputerVO> pricecpu(ComputerVO member) {
			ArrayList<ComputerVO> list = dao.pricecpu(member);
			return list;
		}
		public ArrayList<ComputerVO> priceram(ComputerVO member) {
			ArrayList<ComputerVO> list = dao.priceram(member);
			return list;
		}
		public ArrayList<ComputerVO> pricegpu(ComputerVO member) {
			ArrayList<ComputerVO> list = dao.pricegpu(member);
			return list;
		}
		public ArrayList<ComputerVO> pricecase(ComputerVO member) {
			ArrayList<ComputerVO> list = dao.pricecase(member);
			return list;
		}
		public ArrayList<ComputerVO> pricehdd(ComputerVO member) {
			ArrayList<ComputerVO> list = dao.pricehdd(member);
			return list;
		}
		public ArrayList<ComputerVO> pricessd(ComputerVO member) {
			ArrayList<ComputerVO> list = dao.pricessd(member);
			return list;
		}
		public ArrayList<ComputerVO> pricemb(ComputerVO member) {
			ArrayList<ComputerVO> list = dao.pricemb(member);
			return list;
		}
		public ArrayList<ComputerVO> pricepower(ComputerVO member) {
			ArrayList<ComputerVO> list = dao.pricepower(member);
			return list;
		}
		
		
		public ArrayList<ComputerVO> computerVgaList()
		{
			ArrayList<ComputerVO> list = dao.computerVgaList();
			return list;
		}
		
		public ArrayList<ComputerVO> computerRamList()
		{
			ArrayList<ComputerVO> list = dao.computerRamList();
			return list;
		}
		
		public ArrayList<ComputerVO> computerPowList()
		{
			ArrayList<ComputerVO> list = dao.computerPowList();
			return list;
		}
		
		public ArrayList<ComputerVO> computerMaiList()
		{
			ArrayList<ComputerVO> list = dao.computerMaiList();
			return list;
		}
		
		public ArrayList<ComputerVO> computerHddList()
		{
			ArrayList<ComputerVO> list = dao.computerHddList();
			return list;
		}
		
		public ArrayList<ComputerVO> computerSsdList()
		{
			ArrayList<ComputerVO> list = dao.computerSsdList();
			return list;
		}
		
		public ArrayList<ComputerVO> computerCpuList()
		{
			ArrayList<ComputerVO> list = dao.computerCpuList();
			return list;
		}
		
		public ArrayList<ComputerVO> computerCasList()
		{
			ArrayList<ComputerVO> list = dao.computerCasList();
			return list;
		}

}
