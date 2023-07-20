package model;

import java.util.ArrayList;

// a list of pages
public class Book {
    private ArrayList<Page> pages;


    public Book() {
        this.pages = new ArrayList();
    }

    public int addPage(Page page) {
        pages.add(page);
        return this.pages.size();
    }

    public void removePage(int pageNum) {
        pages.remove(pageNum - 1);
    }

    public Page getPage(int pageNum) {
        return this.pages.get(pageNum - 1);
    }

}


/*
public void editPage(Page editedPage) throws Exception {
        for (int i = 0; i < this.pages.size(); i++) {
            if (this.pages.get(i).getPageID() == editedPage.getPageID()) {
                this.pages.set(i, editedPage);
                return;
            }
        }
        //if code does not find page, will throw error
        throw new Exception("page not found");
    }
 */