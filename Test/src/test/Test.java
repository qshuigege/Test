package test;

import java.net.UnknownHostException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Stack;
import java.util.UUID;
import java.util.Vector;
import java.util.concurrent.Callable;


public class Test implements Callable<String>{
	/*
	public static void main(String[] args) throws Exception {java.lang.Integer
		Date date = new Date();
		System.out.println(date);
		SimpleDateFormat f = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		String dateStr = f.format(date);
		System.out.println(dateStr);
		Date date2 = f.parse(dateStr);
		System.out.println(date2);
		
		Date d = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2015-04-20 14:00:00");
		System.out.println(d);
		
		
		
		
		
		


insert into b2b_interface_note (note_id, inter_id, inter_erpfield, inter_b2bfield, note_filednote, inter_fieldtype) values (seq_b2b_interface_note.nextval,'004','YSHSLL','YSHSLL','','java.lang.String');
insert into b2b_interface_note (note_id, inter_id, inter_erpfield, inter_b2bfield, note_filednote, inter_fieldtype) values (seq_b2b_interface_note.nextval,'004','WSHXS','WSHXS','','java.lang.String');
insert into b2b_interface_note (note_id, inter_id, inter_erpfield, inter_b2bfield, note_filednote, inter_fieldtype) values (seq_b2b_interface_note.nextval,'004','XS','XS','','java.lang.String');
insert into b2b_interface_note (note_id, inter_id, inter_erpfield, inter_b2bfield, note_filednote, inter_fieldtype) values (seq_b2b_interface_note.nextval,'004','GGXH','GGXH','','java.lang.String');
insert into b2b_interface_note (note_id, inter_id, inter_erpfield, inter_b2bfield, note_filednote, inter_fieldtype) values (seq_b2b_interface_note.nextval,'004','SL','SL','','java.lang.String');
insert into b2b_interface_note (note_id, inter_id, inter_erpfield, inter_b2bfield, note_filednote, inter_fieldtype) values (seq_b2b_interface_note.nextval,'004','YSHXSL','YSHXSL','','java.lang.String');
insert into b2b_interface_note (note_id, inter_id, inter_erpfield, inter_b2bfield, note_filednote, inter_fieldtype) values (seq_b2b_interface_note.nextval,'004','WSHSL','WSHSL','','java.lang.String');
insert into b2b_interface_note (note_id, inter_id, inter_erpfield, inter_b2bfield, note_filednote, inter_fieldtype) values (seq_b2b_interface_note.nextval,'004','XH','XH','','java.lang.String');
insert into b2b_interface_note (note_id, inter_id, inter_erpfield, inter_b2bfield, note_filednote, inter_fieldtype) values (seq_b2b_interface_note.nextval,'004','DW','DW','','java.lang.String');
insert into b2b_interface_note (note_id, inter_id, inter_erpfield, inter_b2bfield, note_filednote, inter_fieldtype) values (seq_b2b_interface_note.nextval,'004','MG','MG','','java.lang.String');
insert into b2b_interface_note (note_id, inter_id, inter_erpfield, inter_b2bfield, note_filednote, inter_fieldtype) values (seq_b2b_interface_note.nextval,'004','PM','PM','','java.lang.String');
insert into b2b_interface_note (note_id, inter_id, inter_erpfield, inter_b2bfield, note_filednote, inter_fieldtype) values (seq_b2b_interface_note.nextval,'004','WSHXSL','WSHXSL','','java.lang.String');
insert into b2b_interface_note (note_id, inter_id, inter_erpfield, inter_b2bfield, note_filednote, inter_fieldtype) values (seq_b2b_interface_note.nextval,'004','YSHSL','YSHSL','','java.lang.String');
insert into b2b_interface_note (note_id, inter_id, inter_erpfield, inter_b2bfield, note_filednote, inter_fieldtype) values (seq_b2b_interface_note.nextval,'004','WSHSLL','WSHSLL','','java.lang.String');
insert into b2b_interface_note (note_id, inter_id, inter_erpfield, inter_b2bfield, note_filednote, inter_fieldtype) values (seq_b2b_interface_note.nextval,'004','JG','JG','','java.lang.String');
insert into b2b_interface_note (note_id, inter_id, inter_erpfield, inter_b2bfield, note_filednote, inter_fieldtype) values (seq_b2b_interface_note.nextval,'004','DJ','DJ','','java.lang.String');
insert into b2b_interface_note (note_id, inter_id, inter_erpfield, inter_b2bfield, note_filednote, inter_fieldtype) values (seq_b2b_interface_note.nextval,'004','YSHXS','YSHXS','','java.lang.String');







*/

	
	public static void main(String[] args) throws InterruptedException {
		String str = "{\"GKW01D1_FK\":\"000EB30B-0000-0000-0000-00009217293D\",\"SKFIOrdNo\":\"SPO161212002\",\"SKGCChip\":\"GC0310\",\"SKQty\":\"11\",\"SKDelNo\":\"\",\"SKPNo\":\"\",\"MZCWLNo\":\"C40520A\"}*{\"GKW01D1_FK\":\"000EB30B-0000-0001-0000-00009217441C\",\"SKFIOrdNo\":\"SPO02170215458\",\"SKGCChip\":\"GC2365 \",\"SKQty\":\"22\",\"SKDelNo\":\"\",\"SKPNo\":\"\",\"MZCWLNo\":\"C40701 V0\"}";
		String[] arr = str.split("*");
		for (int i = 0; i < arr.length; i++) {
			System.out.println("-->"+arr[i]);
		}
	}
	
	
	public static void ttt(){
		System.out.println("ttt");
	}
	public void ttee(){
		System.out.println("ttee");
	}


	@Override
	public String call() throws Exception {
		// TODO Auto-generated method stub
		return "aaaooo";
	}
}



