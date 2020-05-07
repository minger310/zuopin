using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.IO;

public partial class add : System.Web.UI.Page
{
    protected void Page_Load(object sender, EventArgs e)
    {

    }

    protected void Wizard1_FinishButtonClick(object sender, WizardNavigationEventArgs e)
    {
        string name = "尊敬的：" + txtName.Text;
        Response.Write("<script>alert('"+name+"感谢您注册')</script>");
    }
    protected void Wizard1_ActiveStepChanged(object sender, EventArgs e)
    {
        lblName.Text = txtName.Text;
        lblPwd.Text = txtPwd.Text;
        lblsex.Text = RadioButtonList1.Text;
        lblPro.Text = "省份：" + ddlPro.Text;
        lblTel.Text = "电话：" + txtTel.Text;
    }




    protected void Button1_Click(object sender, EventArgs e)
    {
        string fname = FileUpload1.FileName;
        string fpath = Server.MapPath("~/media/") + fname;
        string ext = Path.GetExtension(fname);
        string fmessage = "选择的文件名：" + FileUpload1.FileName + "<br/>文件大小：" + FileUpload1.PostedFile.ContentLength + "<br/>文件扩展名：" + ext;
        if (FileUpload1.HasFile)
        {
            FileUpload1.SaveAs(fpath);
            Label l1 = new Label();
            l1.Text = fmessage;
            Page.Controls.Add(l1);
            if (ext == ".jpg")
            {
                Image img = new Image();
                img.ImageUrl = "sc/" + fname;
                img.Width = 400;
                img.Height = 350;
                Page.Controls.Add(img);
            }
            else if (ext == ".mp3" || ext == ".mp4" || ext == ".wmv" || ext == ".gif")
            {
                Literal1.Text = "<embed src='media/" + fname + "'></embed>";
            }

            else
            {
                Response.Write("文件的拓展名：" + ext);
            }
        }
        else
        {
            Response.Write("请选择文件：");
        }
    }
    protected void RadioButton2_SelectedIndexChanged(object sender, EventArgs e)
    {
        MultiView1.ActiveViewIndex = RadioButtonList2.SelectedIndex;
    }
    protected void MultiView1_ActiveViewChanged(object sender, EventArgs e)
    {
        RadioButtonList2.SelectedIndex = MultiView1.ActiveViewIndex;
    }
}
    

