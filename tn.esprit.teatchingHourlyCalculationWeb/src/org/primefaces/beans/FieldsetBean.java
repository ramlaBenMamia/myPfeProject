package org.primefaces.beans;

import javax.annotation.ManagedBean;
import javax.faces.application.FacesMessage;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.ToggleEvent;

@ManagedBean
@SessionScoped
public class FieldsetBean {

	public void handleToggle(ToggleEvent event) {
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
				"Fieldset Toggled", "Visibility:" + event.getVisibility());

		FacesContext.getCurrentInstance().addMessage(null, msg);
	}
}
