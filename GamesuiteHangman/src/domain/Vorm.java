package domain;

public abstract class Vorm implements Drawable
{
	public abstract Omhullende getOmhullende();
	public abstract boolean equals(Object o);
	public abstract String toString();
}