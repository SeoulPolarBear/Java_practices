package dialogs;

public class Name implements Comparable<Name>
{
private String firstname;
private String lastname;

public Name(String firstname, String lastname)
{
this.firstname = firstname;
this.lastname = lastname;
}

public String getFirstname()
{
return firstname;
}

public String getLastname()
{
return lastname;
}

public String toString()
{
return firstname + " " + lastname;
}

public boolean equals(Object obj)
{
if (obj == null) return false;
if (obj.getClass() == getClass())
{
Name n = (Name)obj;
return firstname.equals(n.firstname) && lastname.equals(n.lastname);
}
return false;
}

public int compareTo(Name n)
{
if (lastname.equals(n.lastname)) return firstname.compareTo(n.lastname);
return lastname.compareTo(n.lastname);
}
}
