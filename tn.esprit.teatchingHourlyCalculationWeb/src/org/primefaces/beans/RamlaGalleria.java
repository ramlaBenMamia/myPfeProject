package org.primefaces.beans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class RamlaGalleria {

	private List<String> images = new ArrayList<String>();

	@PostConstruct
	public void init() {
		images.add("galleria1.jpg");
		images.add("galleria2.jpg");
		images.add("galleria3.jpg");
		images.add("galleria4.jpg");
	}

	public List<String> getImages() {

		return images;
	}

	public void setImages(List<String> images) {
		this.images = images;
	}

}
