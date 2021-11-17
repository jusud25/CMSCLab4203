
public class Plot {
   private int x;
   private int y;
   private int width;
   private int depth;
   /**
   * No-arg constructor with a default Plot with set x, y, width, and depth
   */
   public Plot()
   {
       this.x = 0;
       this.y = 0;
       this.width = 1;
       this.depth = 1;
   }
   /**
   * Constructs a new object using the information of the object passed to it
   * @param p
   */
   public Plot(Plot p)
   {
       this.x = p.x;
       this.y = p.y;
       this.width = p.width;
       this.depth = p.depth;
   }
   /**
   * Constructs a new object with the given x, y, width, and depth
   * @param x
   * @param y
   * @param width
   * @param depth
   */
   public Plot(int x, int y, int width, int depth)
   {
       this.x = x;
       this.y = y;
       this.width = width;
       this.depth = depth;
   }
   /**
   * Method checks if plot overlaps
   * @param plot
   * @return true if it overlaps, otherwise false
   */
   public boolean overlaps(Plot plot) {
       return x < plot.x + plot.width && x + width > plot.x && y < plot.y + plot.depth && y + depth > plot.y;
   }
   /**
   * Method checks if plot is within the current plot bounds
   * @param plot
   * @return true if plot encompasses the parameter. otherwise false
   */
   public boolean encompasses(Plot plot) {
       boolean encompass = false;
       double rX = x + width;
       double bttY = y + depth;
       double newRX = plot.getX()+plot.getWidth();
       double newBttY = plot.getY() + plot.getDepth();
       if (this.x<=plot.getX() && plot.getX()<=rX && this.y<=plot.getY() && plot.getY()<=bttY
               && this.x<=rX && newRX<=rX
               && this.y<=newBttY && newBttY<=bttY) {
           encompass = true;
       }
       return encompass;
   }


   /**
   * Gets x
   * @return x
   */
   public int getX()
   {
       return x;
   }
   /**
   * Sets x
   * @param x
   */
   public void setX(int x)
   {
       this.x = x;
   }
   /**
   * Gets y
   * @return y
   */
   public int getY()
   {
       return y;
   }
   /**
   * Sets y
   * @param y
   */
   public void setY(int y)
   {
       this.y = y;
   }
   /**
   * Gets width
   * @return width
   */
   public int getWidth()
   {
       return width;
   }
   /**
   * Sets width
   * @param width
   */
   public void setWidth(int width)
   {
       this.width = width;
   }
   /**
   * Gets depth
   * @return depth
   */
   public int getDepth()
   {
       return depth;
   }
   /**
   * Sets depth
   * @param depth
   */
   public void setDepth(int depth)
   {
       this.depth = depth;
   }
   /**
   * To String
   * @return string
   */
   public String toString()
   {
       return "Upper left: (" + x + "," + y + "); Width: " + width + " Depth: " + depth;
   }
}