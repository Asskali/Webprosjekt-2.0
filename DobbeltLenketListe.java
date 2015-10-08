/*
 * Adam M. Asskali
 * s929539
 * HINGDATA14HA
 */
package oblig2;

import java.util.Iterator;
import java.util.Objects;

import Hjelpeklasser.Liste;

public class DobbeltLenketListe<T> implements Liste<T>
{
	private static final class Node<T> // en indre nodeklasse
	{

		// instansvariabler
		private T verdi;
		private Node<T> forrige, neste;

		// konstruktør
		private Node(T verdi, Node<T> forrige, Node<T> neste)
		{
			this.verdi = verdi;
			this.forrige = forrige;
			this.neste = neste;
		}
	}

	// instansvariabler
	private Node<T> hode; // peker til den første i listen
	private Node<T> hale; // peker til den siste i listen
	private int antall; // antall noder i listen
	private int antallEndringer; // antall endringer i listen

	// hjelpemetode
	private Node<T> finnNode(int indeks)
	{
		throw new UnsupportedOperationException("Ikke laget ennå!");
	}

	// konstruktør
	public DobbeltLenketListe()
	{
		hode = hale = null;
		antall = 0;
		antallEndringer = 0;
	}

	// konstruktør
	public DobbeltLenketListe(T[] a)
	{
		Objects.requireNonNull(a, "Tabellen a er null!");

		int j = 0;

		for(int i = 0; i < a.length; i++)
		{
			if(a[i] != null)
			{
				hode = hale = new Node<T>(a[i], null, null);
				j = i + 1;
				i = a.length;
				antall++;
			}
		}

		if(hode == null)
			return;

		Node<T> p = hode.neste;
		Node<T> f = null;

		for(; j < a.length; j++)
		{
			if(a[j] != null)
			{
				p = new Node<T>(a[j], f, null);
				hale = p;
				f = p;
				p = p.neste;
				antall++;
			}
		}
	}

	@Override
	public int antall()
	{
		return antall;
	}

	@Override
	public boolean tom()
	{
		if(antall == 0)
			return true;
		else
			return false;
	}

	@Override
	public boolean leggInn(T verdi)
	{
		Objects.requireNonNull(verdi, "Verdien er null!");

		if(hode == null)
		{
			hode = hale = new Node<T>(verdi, null, null);
			antall++;
			antallEndringer++;
			return true;
		}
		else
		{
			Node<T> ny = new Node<T>(verdi, hale, null);
			hale = hale.neste = ny;
			antall++;
			antallEndringer++;
			return true;
		}
	}

	@Override
	public void leggInn(int indeks, T verdi)
	{
		throw new UnsupportedOperationException("Ikke laget ennå!");
	}

	@Override
	public boolean inneholder(T verdi)
	{
		throw new UnsupportedOperationException("Ikke laget ennå!");
	}

	@Override
	public T hent(int indeks)
	{
		throw new UnsupportedOperationException("Ikke laget ennå!");
	}

	@Override
	public int indeksTil(T verdi)
	{
		throw new UnsupportedOperationException("Ikke laget ennå!");
	}

	@Override
	public T oppdater(int indeks, T nyverdi)
	{
		throw new UnsupportedOperationException("Ikke laget ennå!");
	}

	@Override
	public boolean fjern(T verdi)
	{
		throw new UnsupportedOperationException("Ikke laget ennå!");
	}

	@Override
	public T fjern(int indeks)
	{
		throw new UnsupportedOperationException("Ikke laget ennå!");
	}

	@Override
	public void nullstill()
	{
		throw new UnsupportedOperationException("Ikke laget ennå!");
	}

	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder("[");
		if(hode == null)
		{
			sb.append("]");
			return sb.toString();
		}
		else if(hode == hale)
		{
			sb.append(hode.verdi + "]");
			return sb.toString();
		}
		Node<T> p = hode;

		while(p != hale)
		{
			sb.append(p.verdi + ", ");
			p = p.neste;
		}

		sb.append(hale.verdi + "]");
		return sb.toString();
	}

	public String omvendtString()
	{
		StringBuilder sb = new StringBuilder("[");
		if(hode == null)
		{
			sb.append("]");
			return sb.toString();
		}
		else if(hode == hale)
		{
			sb.append(hode.verdi + "]");
			return sb.toString();
		}
		Node<T> p = hale;

		while(p != hode)
		{
			sb.append(p.verdi + ", ");
			p = p.forrige;
		}

		sb.append(hode.verdi + "]");
		return sb.toString();
	}

	@Override
	public Iterator<T> iterator()
	{
		throw new UnsupportedOperationException("Ikke laget ennå!");
	}

	public Iterator<T> iterator(int indeks)
	{
		throw new UnsupportedOperationException("Ikke laget ennå!");
	}

	private class DobbeltLenketListeIterator implements Iterator<T>
	{
		private Node<T> denne;
		private boolean fjernOK;
		private int forventetAntallEndringer;

		private DobbeltLenketListeIterator()
		{
			denne = hode; // denne starter på den første i listen
			fjernOK = false; // blir sann når next() kalles
			forventetAntallEndringer = antallEndringer; // teller endringer
		}

		private DobbeltLenketListeIterator(int indeks)
		{
			throw new UnsupportedOperationException("Ikke laget ennå!");
		}

		@Override
		public boolean hasNext()
		{
			return denne != null; // denne koden skal ikke endres!
		}

		@Override
		public T next()
		{
			throw new UnsupportedOperationException("Ikke laget ennå!");
		}

		@Override
		public void remove()
		{
			throw new UnsupportedOperationException("Ikke laget ennå!");
		}

	} // DobbeltLenketListeIterator

} // DobbeltLenketListe
