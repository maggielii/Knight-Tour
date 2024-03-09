package code;

public class Board {

    private LinkedGrid grid;

    public Node temp;
    
    public Board(int dimension) {
        grid = new LinkedGrid(dimension);
    }

    public void display() {
        grid.display();
    }

    public void findKnightTours() {
        tour(grid.getFirst(), 1);
    }

    private void tour(Node n, int step) {

        if (n == null || n.getData() != 0) {
            return;
        }

        n.setData(step);

        if (step == 25) {
            display();
            n.setData(0);
            return;
        }

        Node rightDownDown = n.getRight();
        if (rightDownDown != null) {
            rightDownDown = rightDownDown.getDown();
            if (rightDownDown != null) {
                rightDownDown = rightDownDown.getDown();
            }
        }
        tourIfValid(rightDownDown, step + 1);

        Node rightUpUp = n.getRight();
        if (rightUpUp != null) {
            rightUpUp = rightUpUp.getUp();
            if (rightUpUp != null) {
                rightUpUp = rightUpUp.getUp();
            }
        }
        tourIfValid(rightUpUp, step + 1);

        Node downRightRight = n.getDown();
        if (downRightRight != null) {
            downRightRight = downRightRight.getRight();
            if (downRightRight != null) {
                downRightRight = downRightRight.getRight();
            }
        }
        tourIfValid(downRightRight, step + 1);

        Node downLeftLeft = n.getDown();
        if (downLeftLeft != null) {
            downLeftLeft = downLeftLeft.getLeft();
            if (downLeftLeft != null) {
                downLeftLeft = downLeftLeft.getLeft();
            }
        }
        tourIfValid(downLeftLeft, step + 1);

        Node leftDownDown = n.getLeft();
        if (leftDownDown != null) {
            leftDownDown = leftDownDown.getDown();
            if (leftDownDown != null) {
                leftDownDown = leftDownDown.getDown();
            }
        }
        tourIfValid(leftDownDown, step + 1);

        Node leftUpUp = n.getLeft();
        if (leftUpUp != null) {
            leftUpUp = leftUpUp.getUp();
            if (leftUpUp != null) {
                leftUpUp = leftUpUp.getUp();
            }
        }
        tourIfValid(leftUpUp, step + 1);

        Node upLeftLeft = n.getUp();
        if (upLeftLeft != null) {
            upLeftLeft = upLeftLeft.getLeft();
            if (upLeftLeft != null) {
                upLeftLeft = upLeftLeft.getLeft();
            }
        }
        tourIfValid(upLeftLeft, step + 1);

        Node upRightRight = n.getUp();
        if (upRightRight != null) {
            upRightRight = upRightRight.getRight();
            if (upRightRight != null) {
                upRightRight = upRightRight.getRight();
            }
        }

        tourIfValid(upRightRight, step + 1);

        n.setData(0);
    }

    private void tourIfValid(Node node, int step) {
         if (node != null && node.getData() == 0) {

        	if(degreesOfFreedom(node) == 0)
        	{
        		return;
        	}
        	else if(degreesOfFreedom(node) == 1)
        	{
        		node.setData(step);//works if zero
        		tour(temp, step + 1);
        	}
        	else 
        	{
        		tour(node, step);
        	}
        	
        }
    }
    
    private int degreesOfFreedom(Node node)
    {
    	int zeroCount = 0;
 
    	if(node.getRight() != null && node.getRight().getDown() != null && node.getRight().getDown().getDown() != null && node.getRight().getDown().getDown().getData() == 0)
    	{
    		if(degreesOfFreedomCount(node.getRight().getDown().getDown()) == 1);
    		{
    			zeroCount++;
    			temp = node.getRight().getDown().getDown();
    		}
    	}
    	if(node.getRight() != null && node.getRight().getUp() != null && node.getRight().getUp().getUp() != null && node.getRight().getUp().getUp().getData() == 0)
    	{
    		if(degreesOfFreedomCount(node.getRight().getUp().getUp()) == 1);
    		{
    			zeroCount++;
    			temp = node.getRight().getUp().getUp();
    		}
    	}
    	if(node.getDown() != null && node.getDown().getRight() != null && node.getDown().getRight().getRight() != null && node.getDown().getRight().getRight().getData() == 0)
    	{
    		if(degreesOfFreedomCount(node.getDown().getRight().getRight()) == 1);
    		{
    			zeroCount++;
    			temp = node.getDown().getRight().getRight();
    		}
    	}
    	if(node.getDown() != null && node.getDown().getLeft() != null && node.getDown().getLeft().getLeft() != null && node.getDown().getLeft().getLeft().getData() == 0)
    	{
    		if(degreesOfFreedomCount(node.getDown().getLeft().getLeft()) == 1);
    		{
    			zeroCount++;
    			temp = node.getDown().getLeft().getLeft();
    		}
    	}
    	if(node.getLeft() != null && node.getLeft().getDown() != null && node.getLeft().getDown().getDown() != null && node.getLeft().getDown().getDown().getData() == 0)
    	{
    		if(degreesOfFreedomCount(node.getLeft().getDown().getDown()) == 1);
    		{
    			zeroCount++;
    			temp = node.getLeft().getDown().getDown();
    		}
    	}
    	if(node.getLeft() != null && node.getLeft().getUp() != null && node.getLeft().getUp().getUp() != null && node.getLeft().getUp().getUp().getData() == 0)
    	{
    		if(degreesOfFreedomCount(node.getLeft().getUp().getUp()) == 1);
    		{
    			zeroCount++;
    			temp = node.getLeft().getUp().getUp();
    		}
    	}
    	if(node.getUp() != null && node.getUp().getLeft() != null && node.getUp().getLeft().getLeft() != null && node.getUp().getLeft().getLeft().getData() == 0)
    	{
    		if(degreesOfFreedomCount(node.getUp().getLeft().getLeft()) == 1);
    		{
    			zeroCount++;
    			temp = node.getUp().getLeft().getLeft();
    		}
    	}
    	if(node.getUp() != null && node.getUp().getRight() != null && node.getUp().getRight().getRight() != null && node.getUp().getRight().getRight().getData() == 0)
    	{
    		if(degreesOfFreedomCount(node.getUp().getRight().getRight()) == 1);
    		{
    			zeroCount++;
    			temp = node.getUp().getRight().getRight();
    		}
    	}

    	return zeroCount;
    }
    
    private int degreesOfFreedomCount(Node node)
    {
    	int count = 0;
    	
    	if(node.getRight() != null && node.getRight().getDown() != null && node.getRight().getDown().getDown() != null && node.getRight().getDown().getDown().getData() == 0)
    	{
    		count++;
    	}
    	if(node.getRight() != null && node.getRight().getUp() != null && node.getRight().getUp().getUp() != null && node.getRight().getUp().getUp().getData() == 0)
    	{
    		count++;
    	}
    	if(node.getDown() != null && node.getDown().getRight() != null && node.getDown().getRight().getRight() != null && node.getDown().getRight().getRight().getData() == 0)
    	{
    		count++;
    	}
    	if(node.getDown() != null && node.getDown().getLeft() != null && node.getDown().getLeft().getLeft() != null && node.getDown().getLeft().getLeft().getData() == 0)
    	{
    		count++;
    	}
    	if(node.getLeft() != null && node.getLeft().getDown() != null && node.getLeft().getDown().getDown() != null && node.getLeft().getDown().getDown().getData() == 0)
    	{
    		count++;
    	}
    	if(node.getLeft() != null && node.getLeft().getUp() != null && node.getLeft().getUp().getUp() != null && node.getLeft().getUp().getUp().getData() == 0)
    	{
    		count++;
    	}
    	if(node.getUp() != null && node.getUp().getLeft() != null && node.getUp().getLeft().getLeft() != null && node.getUp().getLeft().getLeft().getData() == 0)
    	{
    		count++;
    	}
    	if(node.getUp() != null && node.getUp().getRight() != null && node.getUp().getRight().getRight() != null && node.getUp().getRight().getRight().getData() == 0)
    	{
    		count++;
    	}

    	return count;
    }
}