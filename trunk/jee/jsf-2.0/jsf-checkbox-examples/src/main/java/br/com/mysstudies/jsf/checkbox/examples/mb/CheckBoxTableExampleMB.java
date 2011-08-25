package br.com.mysstudies.jsf.checkbox.examples.mb;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class CheckBoxTableExampleMB {

	
	
	
	private List<ItemTable> itensTable;
	
	
	
	
	public void showItens(){
		
		itensTable = 
				new ArrayList<CheckBoxTableExampleMB.ItemTable>();
		
		int numberItens = 0;
		
		while (numberItens < 10) {
			
			itensTable.add(
				new ItemTable(
					false, 
					"Iten number.: " + numberItens
				)				
			);
			
			numberItens++;
		} 
	}
	
	
	
	public List<ItemTable> getItensTable() {
		return itensTable;
	}




	public void setItensTable(List<ItemTable> itensTable) {
		this.itensTable = itensTable;
	}




	public class ItemTable{
		
		private boolean checked;
		
		private String description;
		

		public ItemTable(boolean checked, String description) {
			super();
			this.checked = checked;
			this.description = description;
		}

		public boolean isChecked() {
			return checked;
		}

		public void setChecked(boolean isChecked) {
			this.checked = isChecked;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}
			
	}
	
	
}
