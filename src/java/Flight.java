/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author sree
 */
class Route
{
    protected int id;
    String from,to;
        Route(String a,String b)
        {
            from=a;
            to=b;
        }
}
public class Flight extends Route {
protected int id;
int seats_eco,seats_bus;
Float price_eco,price_bus,distance;
String start_time,end_time,company;

    public Flight(int i,String a,float b,String c,String d,String e,String f,int s1,int s2,Float p1,Float p2) {
        super(c,d);
        id=i;
        company=a;
        distance=b;
        start_time=e;
        end_time=f;
        seats_eco=s1;
        seats_bus=s2;
        price_eco=p1;
        price_bus=p2;
    }
    
}
