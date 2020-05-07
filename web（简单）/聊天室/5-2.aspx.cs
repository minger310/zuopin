using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

public partial class _5_2 : System.Web.UI.Page
{
    protected void Page_Load(object sender, EventArgs e)
    {

    }
    protected void Button1_Click(object sender, EventArgs e)
    {
        String path = Server.MapPath("~/hello.txt");
        System.IO.FileInfo file = new System.IO.FileInfo(path);
        Response.Clear();
        Response.Charset = "utf-8";
        Response.ContentEncoding = System.Text.Encoding.UTF8;
        Response.AddHeader("Content-Disposition", "attachment;filename=" + Server.UrlEncode(file.Name));
        Response.ContentType = "application/msword";
        Response.WriteFile(file.FullName);
        Response.End();
    }
    protected void Button2_Click(object sender, EventArgs e)
    {
        String path = Server.MapPath("~/33.gif");
        System.IO.FileInfo file = new System.IO.FileInfo(path);
        Response.Clear();
        Response.Charset = "utf-8";
        Response.ContentEncoding = System.Text.Encoding.UTF8;
        Response.AddHeader("Content-Disposition", "attachment;filename=" + Server.UrlEncode(file.Name));
        Response.ContentType = "image/gif";
        Response.WriteFile(file.FullName);
        Response.End();
    }
}