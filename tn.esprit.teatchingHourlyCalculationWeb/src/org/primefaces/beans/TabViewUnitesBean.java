package org.primefaces.beans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.primefaces.event.TabChangeEvent;

import com.esprit.entity.Unite;

@ManagedBean
@SessionScoped
public class TabViewUnitesBean {
	private List<Unite> unites;

	public TabViewUnitesBean() {
		unites = new ArrayList<Unite>();

		unites.add(new Unite("EspritMobile"));
		unites.add(new Unite("EspritOnLine"));
		unites.add(new Unite("JavaTech"));
		unites.add(new Unite("JEE"));
	}

	public void onTabChange(TabChangeEvent event) {

	}

	public List<Unite> getUnites() {
		return unites;
	}
}
