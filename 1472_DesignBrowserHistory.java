class BrowserHistory {

    Stack<String> backStack;
    Stack<String> forwardStack;
    String currentPage;
    public BrowserHistory(String homepage) {
        currentPage = homepage;
        backStack = new Stack<>();
        forwardStack = new Stack<>();
    }
    
    public void visit(String url) {
        backStack.push(currentPage);
        currentPage=url;
        forwardStack=new Stack<>();
    }
    
    public String back(int steps) {
        while(steps>0 && !backStack.isEmpty()){
            forwardStack.push(currentPage);
            currentPage=backStack.pop();
            steps--;
        }
        return currentPage;
    }
    
    public String forward(int steps) {
        while(steps>0 && !forwardStack.isEmpty()){
            backStack.push(currentPage);
            currentPage=forwardStack.pop();
            steps--;
        }
        return currentPage;
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */