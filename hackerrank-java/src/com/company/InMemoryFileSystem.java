package com.company;

import java.util.ArrayList;

public class InMemoryFileSystem {

    public interface Sort {

    }

    public abstract class Entity
    {
        protected Directory parent;
        protected long created;
        protected long lastUpdated;
        protected long lastAccessed;
        protected String name;

        public Entity(String n, Directory parent)
        {
            name = n;
            this.parent = parent;
            created= System.currentTimeMillis();
            lastUpdated = System.currentTimeMillis();
            lastAccessed = System.currentTimeMillis();
        }

        public boolean delete()
        {
            if (parent == null)
                return false;
            return parent.deleteEntry(this);
        }

        public abstract int size();

        /* Getters and setters. */
        public long getcreationTime()
        {
            return created;
        }
        public long getLastUpdatedTime()
        {
            return lastUpdated;
        }
        public long getLastAccessedTime()
        {
            return lastAccessed;
        }
        public void changeName(String n)
        {
            name = n;
        }
        public String getName()
        {
            return name;
        }
    }


    public class File extends Entity
    {
        private String content;
        private int size;

        public File(String n, Directory p, int sz)
        {
            super(n, p);
            size = sz;
        }
        public int size()
        {
            return size;
        }
        public String getContents()
        {
            return content;
        }
        public void setContents(String c)
        {
            content = c;
        }
    }


    public class Directory extends Entity
    {
        protected ArrayList<Entity> contents;

        public Directory(String n, Directory p)
        {
            super(n, p);
            contents = new ArrayList<Entity>();
        }
        public int size()
        {
            int size = 0;
            for (Entity e : contents)
                size += e.size();

            return size;
        }
        public int numberOfFiles()
        {
            int count = 0;
            for (Entity e : contents)
            {
                if (e instanceof Directory)
                {
                    count++; // Directory counts as a file
                    Directory d = (Directory) e;
                    count += d. numberOfFiles ();
                }
                else if (e instanceof File)
                    count++;
            }
            return count;
        }

        public boolean deleteEntry(Entity entity)
        {
            return contents.remove(entity);
        }

        public void addEntry(Entity entity)
        {
            contents.add(entity);
        }

        protected ArrayList<Entity> getContents()
        {
            return contents;
        }
    }



    public static void main(String[] args) {

    }
}
