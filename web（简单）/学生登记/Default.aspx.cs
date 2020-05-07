using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.Data.OleDb;
using System.Configuration;

public partial class _Default : System.Web.UI.Page
{
    string connstr = ConfigurationManager.ConnectionStrings["conn"].ToString();
    OleDbConnection con1 = new OleDbConnection();
    OleDbCommand cmd = new OleDbCommand();
    protected void Page_Load(object sender, EventArgs e)
    {
        if (!IsPostBack)
        {
            con1.ConnectionString = connstr;
            cmd.Connection = con1;
            cmd.CommandText = "select sno  from student";
            con1.Open();
            OleDbDataReader dr = cmd.ExecuteReader();

            while (dr.Read())
            {
                DropDownList2.Items.Add(dr.GetValue(0).ToString());
            }
            con1.Close();
            GridView1.Visible = false;
        }
    }

    protected void Button1_Click(object sender, EventArgs e)
    {

        con1.ConnectionString = connstr;
        con1.Open();
        OleDbCommand cmd = new OleDbCommand();
        cmd.CommandText = "insert into student values('" + TextBox1.Text + "','" + TextBox2.Text + "','" + DropDownList1.SelectedValue + "','" + TextBox3.Text + "','" + TextBox4.Text + "')";
        cmd.Connection = con1;
        int n = cmd.ExecuteNonQuery();
        con1.Close();
        if (n == 1)
        {
            Label1.Text = "添加新学生信息成功！";
        }
        else
        {
            Label1.Text = "添加新学生信息失败！";
        }
        DropDownList2.Items.Add(TextBox1.Text);

    }

    protected void Button2_Click(object sender, EventArgs e)
    {
        con1.ConnectionString = connstr;
        con1.Open();
        OleDbCommand cmd = new OleDbCommand();
        cmd.CommandText = string.Format("update student set sname='{0}', sex='{1}',age='{2}',dept='{3}' where sno={4}", TextBox2.Text, DropDownList1.SelectedValue, TextBox3.Text, TextBox4.Text, int.Parse(TextBox1.Text));
        cmd.Connection = con1;
        int n = cmd.ExecuteNonQuery();
        con1.Close();
        if (n == 1)
        {
            Label1.Text = "修改学生信息成功！";
        }
        else
        {
            Label1.Text = "修改学生信息失败！";
        }

    }

    protected void Button3_Click(object sender, EventArgs e)
    {
        con1.ConnectionString = connstr;
        con1.Open();
        OleDbCommand cmd = new OleDbCommand();
        cmd.CommandText = string.Format("delete from student where sno={0}", int.Parse(TextBox1.Text));
        cmd.Connection = con1;
        int n = cmd.ExecuteNonQuery();
        con1.Close();
        if (n == 1)
        {
            Label1.Text = "删除新学生信息成功！";
        }
        else
        {
            Label1.Text = "删除新学生信息失败！";
        }
        DropDownList2.Items.Remove(TextBox1.Text);

    }

    protected void Button4_Click(object sender, EventArgs e)
    {
        GridView1.Visible = true;
        con1.ConnectionString = connstr;
        cmd.Connection = con1;
        cmd.CommandText = "select *  from student";
        con1.Open();
        OleDbDataReader dr = cmd.ExecuteReader();
        GridView1.DataSource = dr;
        GridView1.DataBind();

    }

    protected void Button5_Click(object sender, EventArgs e)
    {

    }

    protected void DropDownList2_SelectedIndexChanged(object sender, EventArgs e)
    {
        con1.ConnectionString = connstr;
        cmd.Connection = con1;
        cmd.CommandText = "select *  from student where sno=" + DropDownList2.SelectedValue;
        con1.Open();
        OleDbDataReader dr = cmd.ExecuteReader();
        dr.Read();
        TextBox1.Text = dr.GetValue(0).ToString();
        TextBox2.Text = dr.GetValue(1).ToString();
        DropDownList1.Text = dr.GetValue(2).ToString();
        TextBox3.Text = dr.GetValue(3).ToString();
        TextBox4.Text = dr.GetValue(4).ToString();

    }

    protected void Button6_Click(object sender, EventArgs e)
    {
        GridView2.Visible = true;
        con1.ConnectionString = connstr;
        cmd.Connection = con1;
        cmd.CommandText = "select *  from student where sname like'%" + TextBox5.Text + "%'";
        con1.Open();
        OleDbDataReader dr = cmd.ExecuteReader();
        GridView2.DataSource = dr;
        GridView2.DataBind();

    }

    protected void Button7_Click(object sender, EventArgs e)
    {
        int h = int.Parse(TextBox6.Text);
        int l = int.Parse(TextBox7.Text);
        Table tt = new Table();
        tt.BackColor = System.Drawing.Color.Green;
        tt.BorderColor = System.Drawing.Color.White;
        tt.GridLines = GridLines.Both;
        for (int i = 0; i < h; i++)
        {
            TableRow rows = new TableRow();
            for (int j = 0; j < l; j++)
            {
                TableCell cc = new TableCell();
                cc.Text = i.ToString() + "行" + j.ToString() + "列";
                rows.Cells.Add(cc);
            }
            tt.Rows.Add(rows);
        }
        Panel1.Controls.Add(tt);

    }

    protected void Button8_Click(object sender, EventArgs e)
    {
        con1.ConnectionString = connstr;
        cmd.Connection = con1;
        cmd.CommandText = "select *  from student,sc,course where student.sno=sc.sno and sc.cno=course.cno";
        con1.Open();
        OleDbDataReader dr = cmd.ExecuteReader();
        int n = dr.FieldCount;
        Table tt = new Table();
        tt.BackColor = System.Drawing.Color.DarkSeaGreen;
        tt.BorderColor = System.Drawing.Color.White;
        tt.GridLines = GridLines.Both;
        TableRow tr1 = new TableRow();
        for (int i = 0; i < n; i++)
        {

            TableCell td = new TableCell();
            td.Text = dr.GetName(i).ToString();
            tr1.Cells.Add(td);

        }
        tt.Rows.Add(tr1);

        while (dr.Read())
        {
            TableRow tr = new TableRow();
            for (int i = 0; i < n; i++)
            {
                TableCell td = new TableCell();
                td.Text = dr.GetValue(i).ToString();
                tr.Cells.Add(td);
            }
            tt.Rows.Add(tr);
        }

        Panel2.Controls.Add(tt);
        dr.Close();
        con1.Close();

    }
}