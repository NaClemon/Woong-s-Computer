package com.dev.vo;

import com.dev.vo.*;

public class ComputerVO {
	
	// to check spec
	private int cpu;
	private int ram;
	private int gpu;
	private String game_name;
	
	public String getGame_name() {
		return game_name;
	}
	public void setGame_name(String game_name) {
		this.game_name = game_name;
	}
	public int getCpu() {
		return cpu;
	}
	public void setCpu(int cpu) {
		this.cpu = cpu;
	}
	public int getRam() {
		return ram;
	}
	public void setRam(int ram) {
		this.ram = ram;
	}
	public int getGpu() {
		return gpu;
	}
	public void setGpu(int gpu) {
		this.gpu = gpu;
	}
	
	// ---------cpu------------
	private int cpu_id;
	private String cpu_name;
	private int cpu_price;
	private int cpu_core;
	private int cpu_thread;
	private String cpu_socket;
	private String cpu_img_url1;
	private String cpu_img_url2;
	
	public String getCpu_name() {
		return cpu_name;
	}
	public void setCpu_name(String cpu_name) {
		this.cpu_name = cpu_name;
	}
	public int getCpu_price() {
		return cpu_price;
	}
	public void setCpu_price(int cpu_price) {
		this.cpu_price = cpu_price;
	}
	public int getCpu_core() {
		return cpu_core;
	}
	public void setCpu_core(int cpu_core) {
		this.cpu_core = cpu_core;
	}
	public int getCpu_thread() {
		return cpu_thread;
	}
	public void setCpu_thread(int cpu_thread) {
		this.cpu_thread = cpu_thread;
	}
	public String getCpu_socket() {
		return cpu_socket;
	}
	public void setCpu_socket(String cpu_socket) {
		this.cpu_socket = cpu_socket;
	}
	public String getCpu_img_url1() {
		return cpu_img_url1;
	}
	public void setCpu_img_url1(String cpu_img_url1) {
		this.cpu_img_url1 = cpu_img_url1;
	}
	public String getCpu_img_url2() {
		return cpu_img_url2;
	}
	public void setCpu_img_url2(String cpu_img_url2) {
		this.cpu_img_url2 = cpu_img_url2;
	}

	// ----------ram--------------------
	private int ram_id;
	private String ram_name;
	private int ram_price;
	private int ram_gb;
	private String ram_ddr;
	private String ram_clock;
	private String ram_img_url1;
	private String ram_img_url2;

	public String getRam_name() {
		return ram_name;
	}
	public void setRam_name(String ram_name) {
		this.ram_name = ram_name;
	}
	public int getRam_price() {
		return ram_price;
	}
	public void setRam_price(int ram_price) {
		this.ram_price = ram_price;
	}
	public int getRam_gb() {
		return ram_gb;
	}
	public void setRam_gb(int ram_gb) {
		this.ram_gb = ram_gb;
	}
	public String getRam_ddr() {
		return ram_ddr;
	}
	public void setRam_ddr(String ram_ddr) {
		this.ram_ddr = ram_ddr;
	}
	public String getRam_clock() {
		return ram_clock;
	}
	public void setRam_clock(String ram_clock) {
		this.ram_clock = ram_clock;
	}
	public String getRam_img_url1() {
		return ram_img_url1;
	}
	public void setRam_img_url1(String ram_img_url1) {
		this.ram_img_url1 = ram_img_url1;
	}
	public String getRam_img_url2() {
		return ram_img_url2;
	}
	public void setRam_img_url2(String ram_img_url2) {
		this.ram_img_url2 = ram_img_url2;
	}
	
	// -------------vga-----------------
	private int vga_id;
	private String vga_name;
	private int vga_price;
	private String vga_manu;
	private String vga_model;
	private int vga_mem;
	private String vga_img_url1;
	private String vga_img_url2;

	public String getVga_name() {
		return vga_name;
	}
	public void setVga_name(String vga_name) {
		this.vga_name = vga_name;
	}
	public int getVga_price() {
		return vga_price;
	}
	public void setVga_price(int vga_price) {
		this.vga_price = vga_price;
	}
	public String getVga_manu() {
		return vga_manu;
	}
	public void setVga_manu(String vga_manu) {
		this.vga_manu = vga_manu;
	}
	public String getVga_model() {
		return vga_model;
	}
	public void setVga_model(String vga_model) {
		this.vga_model = vga_model;
	}
	public int getVga_mem() {
		return vga_mem;
	}
	public void setVga_mem(int vga_mem) {
		this.vga_mem = vga_mem;
	}
	public String getVga_img_url1() {
		return vga_img_url1;
	}
	public void setVga_img_url1(String vga_img_url1) {
		this.vga_img_url1 = vga_img_url1;
	}
	public String getVga_img_url2() {
		return vga_img_url2;
	}
	public void setVga_img_url2(String vga_img_url2) {
		this.vga_img_url2 = vga_img_url2;
	}
	
	
	// -------------hdd-----------------
	private int hdd_id;
	private String hdd_name;
	private int hdd_price;
	private String hdd_storage;
	private String hdd_manu;
	private String hdd_type;
	private String hdd_img_url;

	public String getHdd_name() {
		return hdd_name;
	}
	public void setHdd_name(String hdd_name) {
		this.hdd_name = hdd_name;
	}
	public int getHdd_price() {
		return hdd_price;
	}
	public void setHdd_price(int hdd_price) {
		this.hdd_price = hdd_price;
	}
	public String getHdd_storage() {
		return hdd_storage;
	}
	public void setHdd_storage(String hdd_storage) {
		this.hdd_storage = hdd_storage;
	}
	public String getHdd_manu() {
		return hdd_manu;
	}
	public void setHdd_manu(String hdd_manu) {
		this.hdd_manu = hdd_manu;
	}
	public String getHdd_type() {
		return hdd_type;
	}
	public void setHdd_type(String hdd_type) {
		this.hdd_type = hdd_type;
	}
	public String getHdd_img_url() {
		return hdd_img_url;
	}
	public void setHdd_img_url(String hdd_img_url) {
		this.hdd_img_url = hdd_img_url;
	}
	
	// -------------ssd-----------------
	private int ssd_id;
	private String ssd_name;
	private int ssd_price;
	private String ssd_storage;
	private String ssd_manu;
	private String ssd_type;
	private String ssd_img_url;

	public String getSsd_name() {
		return ssd_name;
	}
	public void setSsd_name(String ssd_name) {
		this.ssd_name = ssd_name;
	}
	public int getSsd_price() {
		return ssd_price;
	}
	public void setSsd_price(int ssd_price) {
		this.ssd_price = ssd_price;
	}
	public String getSsd_storage() {
		return ssd_storage;
	}
	public void setSsd_storage(String ssd_storage) {
		this.ssd_storage = ssd_storage;
	}
	public String getSsd_manu() {
		return ssd_manu;
	}
	public void setSsd_manu(String ssd_manu) {
		this.ssd_manu = ssd_manu;
	}
	public String getSsd_type() {
		return ssd_type;
	}
	public void setSsd_type(String ssd_type) {
		this.ssd_type = ssd_type;
	}
	public String getSsd_img_url() {
		return ssd_img_url;
	}
	public void setSsd_img_url(String ssd_img_url) {
		this.ssd_img_url = ssd_img_url;
	}
	
	// -------------case-----------------
	private int case_id;
	private String case_name;
	private int case_price;
	private String case_type;
	private String case_standard;
	private String case_img_url1;
	private String case_img_url2;

	public String getCase_name() {
		return case_name;
	}
	public void setCase_name(String case_name) {
		this.case_name = case_name;
	}
	public int getCase_price() {
		return case_price;
	}
	public void setCase_price(int case_price) {
		this.case_price = case_price;
	}
	public String getCase_type() {
		return case_type;
	}
	public void setCase_type(String case_type) {
		this.case_type = case_type;
	}
	public String getCase_standard() {
		return case_standard;
	}
	public void setCase_standard(String case_standard) {
		this.case_standard = case_standard;
	}
	public String getCase_img_url1() {
		return case_img_url1;
	}
	public void setCase_img_url1(String case_img_url1) {
		this.case_img_url1 = case_img_url1;
	}
	public String getCase_img_url2() {
		return case_img_url2;
	}
	public void setCase_img_url2(String case_img_url2) {
		this.case_img_url2 = case_img_url2;
	}
	
	// -------------power-----------------
	private int power_id;
	private String power_name;
	private int power_price;
	private String power_output;
	private String power_type;
	private String power_img_url;

	public String getPower_name() {
		return power_name;
	}
	public void setPower_name(String power_name) {
		this.power_name = power_name;
	}
	public int getPower_price() {
		return power_price;
	}
	public void setPower_price(int power_price) {
		this.power_price = power_price;
	}
	public String getPower_output() {
		return power_output;
	}
	public void setPower_output(String power_output) {
		this.power_output = power_output;
	}
	public String getPower_type() {
		return power_type;
	}
	public void setPower_type(String power_type) {
		this.power_type = power_type;
	}
	public String getPower_img_url() {
		return power_img_url;
	}
	public void setPower_img_url(String power_img_url) {
		this.power_img_url = power_img_url;
	}
	
	// -------------mb-----------------
	private int mb_id;
	public int getCpu_id() {
		return cpu_id;
	}
	public void setCpu_id(int cpu_id) {
		this.cpu_id = cpu_id;
	}
	public int getRam_id() {
		return ram_id;
	}
	public void setRam_id(int ram_id) {
		this.ram_id = ram_id;
	}
	public int getVga_id() {
		return vga_id;
	}
	public void setVga_id(int vga_id) {
		this.vga_id = vga_id;
	}
	public int getHdd_id() {
		return hdd_id;
	}
	public void setHdd_id(int hdd_id) {
		this.hdd_id = hdd_id;
	}
	public int getSsd_id() {
		return ssd_id;
	}
	public void setSsd_id(int ssd_id) {
		this.ssd_id = ssd_id;
	}
	public int getCase_id() {
		return case_id;
	}
	public void setCase_id(int case_id) {
		this.case_id = case_id;
	}
	public int getPower_id() {
		return power_id;
	}
	public void setPower_id(int power_id) {
		this.power_id = power_id;
	}
	public int getMb_id() {
		return mb_id;
	}
	public void setMb_id(int mb_id) {
		this.mb_id = mb_id;
	}

	private String mb_name;
	private int mb_price;
	private String mb_support_cpu;
	private String mb_standard;
	private String mb_socket;
	private String mb_chipset;
	private String mb_img_url1;
	private String mb_img_url2;

	public String getMb_name() {
		return mb_name;
	}
	public void setMb_name(String mb_name) {
		this.mb_name = mb_name;
	}
	public int getMb_price() {
		return mb_price;
	}
	public void setMb_price(int mb_price) {
		this.mb_price = mb_price;
	}
	public String getMb_support_cpu() {
		return mb_support_cpu;
	}
	public void setMb_support_cpu(String mb_support_cpu) {
		this.mb_support_cpu = mb_support_cpu;
	}
	public String getMb_standard() {
		return mb_standard;
	}
	public void setMb_standard(String mb_standard) {
		this.mb_standard = mb_standard;
	}
	public String getMb_socket() {
		return mb_socket;
	}
	public void setMb_socket(String mb_socket) {
		this.mb_socket = mb_socket;
	}
	public String getMb_chipset() {
		return mb_chipset;
	}
	public void setMb_chipset(String mb_chipset) {
		this.mb_chipset = mb_chipset;
	}
	public String getMb_img_url1() {
		return mb_img_url1;
	}
	public void setMb_img_url1(String mb_img_url1) {
		this.mb_img_url1 = mb_img_url1;
	}
	public String getMb_img_url2() {
		return mb_img_url2;
	}
	public void setMb_img_url2(String mb_img_url2) {
		this.mb_img_url2 = mb_img_url2;
	}
	
	
	// ------------jino-----------
		private String jino_ram_name;
		private int jino_ram_price1;
		private int jino_ram_price2;
		private String jino_ram_ddr;
		private String jino_ram_spd;
		private String jino_ram_img1;
		private String jino_ram_img2;

		public String getJino_ram_name() {
			return jino_ram_name;
		}
		public void setJino_ram_name(String jino_ram_name) {
			this.jino_ram_name = jino_ram_name;
		}
		public int getJino_ram_price1() {
			return jino_ram_price1;
		}
		public void setJino_ram_price1(int jino_ram_price1) {
			this.jino_ram_price1 = jino_ram_price1;
		}
		public int getJino_ram_price2() {
			return jino_ram_price2;
		}
		public void setJino_ram_price2(int jino_ram_price2) {
			this.jino_ram_price2 = jino_ram_price2;
		}
		public String getJino_ram_ddr() {
			return jino_ram_ddr;
		}
		public void setJino_ram_ddr(String jino_ram_ddr) {
			this.jino_ram_ddr = jino_ram_ddr;
		}
		public String getJino_ram_spd() {
			return jino_ram_spd;
		}
		public void setJino_ram_spd(String jino_ram_spd) {
			this.jino_ram_spd = jino_ram_spd;
		}
		public String getJino_ram_img1() {
			return jino_ram_img1;
		}
		public void setJino_ram_img1(String jino_ram_img1) {
			this.jino_ram_img1 = jino_ram_img1;
		}
		public String getJino_ram_img2() {
			return jino_ram_img2;
		}
		public void setJino_ram_img2(String jino_ram_img2) {
			this.jino_ram_img2 = jino_ram_img2;
		}

		private String jino_vga_name;
		private int jino_vga_price;
		private String jino_vga_dev;
		private String jino_vga_mod;
		private String jino_vga_mem;
		private String jino_vga_img1;
		private String jino_vga_img2;
		
		private String jino_pow_name;
		private int jino_pow_price;
		private String jino_pow_output;
		private String jino_pow_type;
		private String jino_pow_img;

		private String jino_mai_name;
		private int jino_mai_price;
		private String jino_mai_dev;
		private String jino_mai_socket;
		private String jino_mai_chip;
		private String jino_mai_bz;
		private String jino_mai_img;

		private String jino_ssd_name;
		private int jino_ssd_price;
		private String jino_ssd_storage;
		private String jino_ssd_manufacturer;
		private String jino_ssd_type;
		private String jino_ssd_img;

		private String jino_hdd_name;
		private int jino_hdd_price;
		private String jino_hdd_storage;
		private String jino_hdd_manufacturer;
		private String jino_hdd_type;
		private String jino_hdd_img;

		private String jino_cpu_name;
		private int jino_cpu_price;
		private String jino_cpu_core;
		private String jino_cpu_thred;
		private String jino_cpu_spd;
		private String jino_cpu_socket;
		private String jino_cpu_img;

		private String jino_cas_name;
		private int jino_cas_price;
		private String jino_cas_dev;
		private String jino_cas_type;
		private String jino_cas_size;
		private String jino_cas_img;

		public String getJino_vga_name() {
			return jino_vga_name;
		}
		public void setJino_vga_name(String jino_vga_name) {
			this.jino_vga_name = jino_vga_name;
		}
		public int getJino_vga_price() {
			return jino_vga_price;
		}
		public void setJino_vga_price(int jino_vga_price) {
			this.jino_vga_price = jino_vga_price;
		}
		public String getJino_vga_dev() {
			return jino_vga_dev;
		}
		public void setJino_vga_dev(String jino_vga_dev) {
			this.jino_vga_dev = jino_vga_dev;
		}
		public String getJino_vga_mod() {
			return jino_vga_mod;
		}
		public void setJino_vga_mod(String jino_vga_mod) {
			this.jino_vga_mod = jino_vga_mod;
		}
		public String getJino_vga_mem() {
			return jino_vga_mem;
		}
		public void setJino_vga_mem(String jino_vga_mem) {
			this.jino_vga_mem = jino_vga_mem;
		}
		public String getJino_vga_img1() {
			return jino_vga_img1;
		}
		public void setJino_vga_img1(String jino_vga_img1) {
			this.jino_vga_img1 = jino_vga_img1;
		}
		public String getJino_vga_img2() {
			return jino_vga_img2;
		}
		public void setJino_vga_img2(String jino_vga_img2) {
			this.jino_vga_img2 = jino_vga_img2;
		}
		public String getJino_pow_name() {
			return jino_pow_name;
		}
		public void setJino_pow_name(String jino_pow_name) {
			this.jino_pow_name = jino_pow_name;
		}
		public int getJino_pow_price() {
			return jino_pow_price;
		}
		public void setJino_pow_price(int jino_pow_price) {
			this.jino_pow_price = jino_pow_price;
		}
		public String getJino_pow_output() {
			return jino_pow_output;
		}
		public void setJino_pow_output(String jino_pow_output) {
			this.jino_pow_output = jino_pow_output;
		}
		public String getJino_pow_type() {
			return jino_pow_type;
		}
		public void setJino_pow_type(String jino_pow_type) {
			this.jino_pow_type = jino_pow_type;
		}
		public String getJino_pow_img() {
			return jino_pow_img;
		}
		public void setJino_pow_img(String jino_pow_img) {
			this.jino_pow_img = jino_pow_img;
		}
		public String getJino_mai_name() {
			return jino_mai_name;
		}
		public void setJino_mai_name(String jino_mai_name) {
			this.jino_mai_name = jino_mai_name;
		}
		public int getJino_mai_price() {
			return jino_mai_price;
		}
		public void setJino_mai_price(int jino_mai_price) {
			this.jino_mai_price = jino_mai_price;
		}
		public String getJino_mai_dev() {
			return jino_mai_dev;
		}
		public void setJino_mai_dev(String jino_mai_dev) {
			this.jino_mai_dev = jino_mai_dev;
		}
		public String getJino_mai_socket() {
			return jino_mai_socket;
		}
		public void setJino_mai_socket(String jino_mai_socket) {
			this.jino_mai_socket = jino_mai_socket;
		}
		public String getJino_mai_chip() {
			return jino_mai_chip;
		}
		public void setJino_mai_chip(String jino_mai_chip) {
			this.jino_mai_chip = jino_mai_chip;
		}
		public String getJino_mai_bz() {
			return jino_mai_bz;
		}
		public void setJino_mai_bz(String jino_mai_bz) {
			this.jino_mai_bz = jino_mai_bz;
		}
		public String getJino_mai_img() {
			return jino_mai_img;
		}
		public void setJino_mai_img(String jino_mai_img) {
			this.jino_mai_img = jino_mai_img;
		}
		public String getJino_ssd_name() {
			return jino_ssd_name;
		}
		public void setJino_ssd_name(String jino_ssd_name) {
			this.jino_ssd_name = jino_ssd_name;
		}
		public int getJino_ssd_price() {
			return jino_ssd_price;
		}
		public void setJino_ssd_price(int jino_ssd_price) {
			this.jino_ssd_price = jino_ssd_price;
		}
		public String getJino_ssd_storage() {
			return jino_ssd_storage;
		}
		public void setJino_ssd_storage(String jino_ssd_storage) {
			this.jino_ssd_storage = jino_ssd_storage;
		}
		public String getJino_ssd_manufacturer() {
			return jino_ssd_manufacturer;
		}
		public void setJino_ssd_manufacturer(String jino_ssd_manufacturer) {
			this.jino_ssd_manufacturer = jino_ssd_manufacturer;
		}
		public String getJino_ssd_type() {
			return jino_ssd_type;
		}
		public void setJino_ssd_type(String jino_ssd_type) {
			this.jino_ssd_type = jino_ssd_type;
		}
		public String getJino_ssd_img() {
			return jino_ssd_img;
		}
		public void setJino_ssd_img(String jino_ssd_img) {
			this.jino_ssd_img = jino_ssd_img;
		}
		public String getJino_hdd_name() {
			return jino_hdd_name;
		}
		public void setJino_hdd_name(String jino_hdd_name) {
			this.jino_hdd_name = jino_hdd_name;
		}
		public int getJino_hdd_price() {
			return jino_hdd_price;
		}
		public void setJino_hdd_price(int jino_hdd_price) {
			this.jino_hdd_price = jino_hdd_price;
		}
		public String getJino_hdd_storage() {
			return jino_hdd_storage;
		}
		public void setJino_hdd_storage(String jino_hdd_storage) {
			this.jino_hdd_storage = jino_hdd_storage;
		}
		public String getJino_hdd_manufacturer() {
			return jino_hdd_manufacturer;
		}
		public void setJino_hdd_manufacturer(String jino_hdd_manufacturer) {
			this.jino_hdd_manufacturer = jino_hdd_manufacturer;
		}
		public String getJino_hdd_type() {
			return jino_hdd_type;
		}
		public void setJino_hdd_type(String jino_hdd_type) {
			this.jino_hdd_type = jino_hdd_type;
		}
		public String getJino_hdd_img() {
			return jino_hdd_img;
		}
		public void setJino_hdd_img(String jino_hdd_img) {
			this.jino_hdd_img = jino_hdd_img;
		}
		public String getJino_cpu_name() {
			return jino_cpu_name;
		}
		public void setJino_cpu_name(String jino_cpu_name) {
			this.jino_cpu_name = jino_cpu_name;
		}
		public int getJino_cpu_price() {
			return jino_cpu_price;
		}
		public void setJino_cpu_price(int jino_cpu_price) {
			this.jino_cpu_price = jino_cpu_price;
		}
		public String getJino_cpu_core() {
			return jino_cpu_core;
		}
		public void setJino_cpu_core(String jino_cpu_core) {
			this.jino_cpu_core = jino_cpu_core;
		}
		public String getJino_cpu_thred() {
			return jino_cpu_thred;
		}
		public void setJino_cpu_thred(String jino_cpu_thred) {
			this.jino_cpu_thred = jino_cpu_thred;
		}
		public String getJino_cpu_spd() {
			return jino_cpu_spd;
		}
		public void setJino_cpu_spd(String jino_cpu_spd) {
			this.jino_cpu_spd = jino_cpu_spd;
		}
		public String getJino_cpu_socket() {
			return jino_cpu_socket;
		}
		public void setJino_cpu_socket(String jino_cpu_socket) {
			this.jino_cpu_socket = jino_cpu_socket;
		}
		public String getJino_cpu_img() {
			return jino_cpu_img;
		}
		public void setJino_cpu_img(String jino_cpu_img) {
			this.jino_cpu_img = jino_cpu_img;
		}
		public String getJino_cas_name() {
			return jino_cas_name;
		}
		public void setJino_cas_name(String jino_cas_name) {
			this.jino_cas_name = jino_cas_name;
		}
		public int getJino_cas_price() {
			return jino_cas_price;
		}
		public void setJino_cas_price(int jino_cas_price) {
			this.jino_cas_price = jino_cas_price;
		}
		public String getJino_cas_dev() {
			return jino_cas_dev;
		}
		public void setJino_cas_dev(String jino_cas_dev) {
			this.jino_cas_dev = jino_cas_dev;
		}
		public String getJino_cas_type() {
			return jino_cas_type;
		}
		public void setJino_cas_type(String jino_cas_type) {
			this.jino_cas_type = jino_cas_type;
		}
		public String getJino_cas_size() {
			return jino_cas_size;
		}
		public void setJino_cas_size(String jino_cas_size) {
			this.jino_cas_size = jino_cas_size;
		}
		public String getJino_cas_img() {
			return jino_cas_img;
		}
		public void setJino_cas_img(String jino_cas_img) {
			this.jino_cas_img = jino_cas_img;
		}

		

}
