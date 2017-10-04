﻿using System;
using Gtk;
using System.Data;
using MySql.Data.MySqlClient;


public partial class MainWindow : Gtk.Window
{
    private static IDbConnection connection;
    public MainWindow() : base(Gtk.WindowType.Toplevel)
    {
        Build();



        string connectionString = "server=localhost;database=dbprueba;user=root;password=sistemas";
        connection = new MySqlConnection(connectionString);
        connection.Open();

        treeView.AppendColumn("id", new CellRendererText(), "text", 0);
        treeView.AppendColumn("nombre", new CellRendererText(), "text", 1);
        ListStore listStore = new ListStore(typeof(string), typeof(string));
        treeView.Model = listStore;

		IDbCommand dbCommand = connection.CreateCommand();
		dbCommand.CommandText = "select * from categoria order by id";
        IDataReader dataReader = dbCommand.ExecuteReader();
        while (dataReader.Read())
            listStore.AppendValues(dataReader["id"].ToString(), dataReader["nombre"]);
        dataReader.Close();
    }

    protected void OnDeleteEvent(object sender, DeleteEventArgs a)
    {
        Application.Quit();
        a.RetVal = true;
    }
}
