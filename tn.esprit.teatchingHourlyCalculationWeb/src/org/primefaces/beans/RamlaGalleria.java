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
		images.add("galleria11.jpg");
		images.add("galleria6.jpg");
		images.add("galleria7.jpg");
		images.add("galleria8.jpg");
		images.add("galleria10.jpg");
		images.add("galleria11.jpg");
		images.add("galleria12.jpg");
		images.add("galleria13.jpg");
		images.add("galleria14.jpg");



	}

	public List<String> getImages() {

		return images;
	}

	public void setImages(List<String> images) {
		this.images = images;
	}

}
