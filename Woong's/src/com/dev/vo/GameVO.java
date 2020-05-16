package com.dev.vo;

import com.dev.vo.*;

public class GameVO {
	
	private int game_id;
	private String game_name;
	private int game_price;
	private String game_date;
	private String game_dev;
	private String game_pub;
	private String game_cont;
	private String img_url;
	
	// ------------ game min spec-------------
	private String min_os;
	private String min_proc;
	private String min_mem;
	private String min_graphic;
	private int min_cpu;
	private int min_ram;
	private int min_gpu;
	
	public String getMin_os() {
		return min_os;
	}
	public void setMin_os(String min_os) {
		this.min_os = min_os;
	}
	public String getMin_proc() {
		return min_proc;
	}
	public void setMin_proc(String min_proc) {
		this.min_proc = min_proc;
	}
	public String getMin_mem() {
		return min_mem;
	}
	public void setMin_mem(String min_mem) {
		this.min_mem = min_mem;
	}
	public String getMin_graphic() {
		return min_graphic;
	}
	public void setMin_graphic(String min_graphic) {
		this.min_graphic = min_graphic;
	}
	public int getMin_cpu() {
		return min_cpu;
	}
	public void setMin_cpu(int min_cpu) {
		this.min_cpu = min_cpu;
	}
	public int getMin_ram() {
		return min_ram;
	}
	public void setMin_ram(int min_ram) {
		this.min_ram = min_ram;
	}
	public int getMin_gpu() {
		return min_gpu;
	}
	public void setMin_gpu(int min_gpu) {
		this.min_gpu = min_gpu;
	}


	// -------------gmae rec spec-------------
	private String rec_os;
	private String rec_proc;
	private String rec_mem;
	private String rec_graphic;
	private int rec_cpu;
	private int rec_ram;
	private int rec_gpu;
	
	public String getRec_os() {
		return rec_os;
	}
	public void setRec_os(String rec_os) {
		this.rec_os = rec_os;
	}
	public String getRec_proc() {
		return rec_proc;
	}
	public void setRec_proc(String rec_proc) {
		this.rec_proc = rec_proc;
	}
	public String getRec_mem() {
		return rec_mem;
	}
	public void setRec_mem(String rec_mem) {
		this.rec_mem = rec_mem;
	}
	public String getRec_graphic() {
		return rec_graphic;
	}
	public void setRec_graphic(String rec_graphic) {
		this.rec_graphic = rec_graphic;
	}
	public int getRec_cpu() {
		return rec_cpu;
	}
	public void setRec_cpu(int rec_cpu) {
		this.rec_cpu = rec_cpu;
	}
	public int getRec_ram() {
		return rec_ram;
	}
	public void setRec_ram(int rec_ram) {
		this.rec_ram = rec_ram;
	}
	public int getRec_gpu() {
		return rec_gpu;
	}
	public void setRec_gpu(int rec_gpu) {
		this.rec_gpu = rec_gpu;
	}


	// -------------game genre---------------------
	private int genre_id;
	private String genre_name;
	
	public int getGenre_id() {
		return genre_id;
	}
	public void setGenre_id(int genre_id) {
		this.genre_id = genre_id;
	}
	public String getGenre_name() {
		return genre_name;
	}
	public void setGenre_name(String genre_name) {
		this.genre_name = genre_name;
	}
	
	
	
	public int getGame_id() {
		return game_id;
	}
	public void setGame_id(int game_id) {
		this.game_id = game_id;
	}
	public String getGame_name() {
		return game_name;
	}
	public void setGame_name(String game_name) {
		this.game_name = game_name;
	}
	public int getGame_price() {
		return game_price;
	}
	public void setGame_price(int game_price) {
		this.game_price = game_price;
	}
	public String getGame_date() {
		return game_date;
	}
	public void setGame_date(String game_date) {
		this.game_date = game_date;
	}
	public String getGame_dev() {
		return game_dev;
	}
	public void setGame_dev(String game_dev) {
		this.game_dev = game_dev;
	}
	public String getGame_pub() {
		return game_pub;
	}
	public void setGame_pub(String game_pub) {
		this.game_pub = game_pub;
	}
	public String getGame_cont() {
		return game_cont;
	}
	public void setGame_cont(String game_cont) {
		this.game_cont = game_cont;
	}
	public String getImg_url() {
		return img_url;
	}
	public void setImg_url(String img_url) {
		this.img_url = img_url;
	}
}
