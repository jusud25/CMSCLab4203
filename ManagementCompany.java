public class ManagementCompany {
	private  int  MAX_PROPERTY = 5;
	private  int MAX_WIDTH = 10;
	private  int MAX_DEPTH = 10; 

	private double mgmFeePer;
	private String name; 
	private Property[]properties; 
	private String taxID; 
	private Plot plot; 



	public ManagementCompany() {
		this.name = "";
		this.taxID = "";
		this.plot = new Plot(0,0,MAX_WIDTH,MAX_DEPTH);
		this.properties = new Property[MAX_PROPERTY];
	}



	public ManagementCompany(String name,String taxID,double mgmFeePer) {
		this.name = name; 
		this.taxID = taxID; 
		this.mgmFeePer = mgmFeePer; 
		plot = new Plot(0,0,MAX_WIDTH,MAX_DEPTH);
		this.properties = new Property[MAX_PROPERTY];
	}


	
	public ManagementCompany(String name,String taxID, double mgmFeePer, int x, int y, int width, int depth) {
		this.name = name;
		this.taxID = taxID; 
		this.mgmFeePer = mgmFeePer; 
		this.plot = new Plot(x,y,width,depth);
		this.properties =new Property[MAX_PROPERTY];
	}



	public ManagementCompany(ManagementCompany otherCompany) {
		this.properties = new Property[MAX_PROPERTY];
		this.name = otherCompany.name;
		this.taxID = otherCompany.taxID;
		this.mgmFeePer = otherCompany.mgmFeePer;
		this.plot = otherCompany.plot;
	}



	
	public String getName() {
		return this.name; 
	} 


	
	public Plot getPlot() {
		return this.plot;
	}


	
	public int addProperty(Property p) {
		
		  if (p == null)
		  {
	            return -2;
		  }
	        else if (!this.plot.encompasses(p.getPlot()))
	        {
	            return -3;
	        }
	        for (int i = 0; i < MAX_PROPERTY; i++) {
	        	
	            if (properties[i] != null) {
	            	
	                if (p.getPlot().overlaps(properties[i].getPlot())) {
	                	
	                    return -4;
	                }
	                
	            } 
	            
	            else {
	                break;
	            }
	        }
	        for (int i = 0; i < MAX_PROPERTY; i++) {
	        	
	            if (properties[i] == null) {
	            	
	                properties[i] = new Property(p);
	                return i;
	            }
	        }
	        return -1;

	}


public int addProperty(String name,String city,double rent,String owner, int x, int y, int width,int depth) {
		
		return addProperty(new Property(name,city,rent,owner,x,y,width,depth));
		
	}

	
	public int addProperty(String name,String city,double rent,String owner) {		
		
		return addProperty(new Property(name,city,rent,owner));

	}


	
	

	
	public String displayPropertyAtIndex(int i){

		return properties[i].toString()+"";
		
	}


	public int getMAX_PROPERTY() {
		return MAX_PROPERTY;
	}


	
	public double maxRentProp() {
		
		return properties[maxRentPropertyIndex()].getRentAmount();
	}


	
	private int maxRentPropertyIndex() {
		int indexAmount = 0;

		double maxAmount = 0;
		for(int i = 0; i<MAX_PROPERTY;i++) {
			
			if(properties[i]!=null) {
				
				
				if(properties[i].getRentAmount() > maxAmount) {
					
					maxAmount = properties[i].getRentAmount();
					indexAmount = i; 
				}
			}

		}
		return indexAmount;    
	}


	
	
	
	public String toString() {
		String scale = "";
		scale = ("List of the properties for Alliance, taxID: " + taxID+"\n"+""
				+ "__________________________________________________\n");

		

		for(int i = 0; i < MAX_PROPERTY; i++) {

			if(properties[i] != null)
				scale += (" Property Name: " + properties[i].getPropertyName() +"\n" +//getPropertyName()
						"  Located in: " + properties[i].getCity() + "\n" + 
						"  Belonging to: " + properties[i].getOwner() + "\n" + 
						"  Rent Amount: " + properties[i].getRentAmount()+"\n"); 

		}
		
		scale += ("__________________________________________________\n"
				+ ""+"Total management Fee: " + mgmFeePer);
		


		return scale;
	}


	public double totalRent() {
		double totalAmount = 0.0;
		for(int i = 0; i < MAX_PROPERTY; i++) {

			if(properties[i] != null) {
				totalAmount += properties[i].getRentAmount();
				
			}

		}

		return totalAmount; 
	}


}
