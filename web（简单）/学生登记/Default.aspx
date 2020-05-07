<%@ Page Language="C#" AutoEventWireup="true" CodeFile="Default.aspx.cs" Inherits="_Default" %>

<!DOCTYPE html>



<style type="text/css">
    .auto-style1
    {
        width: 182px;
    }
    .auto-style2 {
        width: 182px;
        height: 26px;
    }
    .auto-style3 {
        height: 26px;
    }
    .auto-style4 {
        width: 182px;
        height: 30px;
    }
    .auto-style5 {
        height: 30px;
    }
    .auto-style6 {
        width: 182px;
        height: 54px;
    }
    .auto-style7 {
        height: 54px;
    }
</style>




<form id="form1" runat="server">

<div>
    <asp:Button ID="Button7" runat="server" OnClick="Button7_Click" Text="创建" />
    <br />
    <br />
    <br />
    <br />
    输入表格行列：<asp:TextBox ID="TextBox6" runat="server"></asp:TextBox>
&nbsp; 列：<asp:TextBox ID="TextBox7" runat="server" Width="190px"></asp:TextBox>
    <br />
    <asp:Panel ID="Panel1" runat="server">
    </asp:Panel>
    <asp:Button ID="Button8" runat="server" OnClick="Button8_Click" Text="显示多表查询结果" />
    <asp:Panel ID="Panel2" runat="server">
        <br />
        <br />
        <br />
        <br />
        <br />
    </asp:Panel>
    <br />
    <br />
    <br />
    <br />
    <table style="width: 50%;">
        <tr>
            <td class="auto-style1">学号：</td>
            <td>
                <asp:TextBox ID="TextBox1" runat="server"></asp:TextBox>
            </td>
            
        </tr>
        <tr>
            <td class="auto-style1">姓名：</td>
            <td>
                <asp:TextBox ID="TextBox2" runat="server"></asp:TextBox>
            </td>
            
        </tr>
        <tr>
            <td class="auto-style1">性别：</td>
            <td>
                
                <asp:DropDownList ID="DropDownList1" runat="server">
                    <asp:ListItem>男</asp:ListItem>
                    <asp:ListItem>女</asp:ListItem>
                </asp:DropDownList>
                
            </td>
            
        </tr>
        <tr>
            <td class="auto-style4">年龄：</td>
            <td class="auto-style5">
                <asp:TextBox ID="TextBox3" runat="server"></asp:TextBox>
            </td>
            
        </tr>
        <tr>
            <td class="auto-style2">系：</td>
            <td class="auto-style3">
                <asp:TextBox ID="TextBox4" runat="server"></asp:TextBox>
            </td>
            
        </tr>
        <tr>
            <td class="auto-style6">
                <asp:Button ID="Button1" runat="server" OnClick="Button1_Click" Text="插入" />
            &nbsp;
                <asp:Button ID="Button2" runat="server" Text="修改" Width="39px" OnClick="Button2_Click" />
&nbsp;
                <asp:Button ID="Button3" runat="server" Text="删除" Width="37px" OnClick="Button3_Click" />
                <asp:Button ID="Button4" runat="server" OnClick="Button4_Click" Text="显示" />
            </td>
            <td class="auto-style7">
               
                <asp:Label ID="Label1" runat="server" Text="Label"></asp:Label>
               
                <br />
               
            </td>
            
        </tr>
    </table>
</div>

    <br />
    <br />

    <asp:GridView ID="GridView1" runat="server">
    </asp:GridView>
    <br />
    <br />
                <asp:TextBox ID="TextBox5" runat="server"></asp:TextBox>
            <asp:Button ID="Button6" runat="server" OnClick="Button6_Click" Text="模糊查询" />
    <asp:DropDownList ID="DropDownList2" runat="server" OnSelectedIndexChanged="DropDownList2_SelectedIndexChanged">
    </asp:DropDownList>
    <asp:Button ID="Button5" runat="server" OnClick="Button5_Click" Text="查询" />
    <asp:GridView ID="GridView2" runat="server">
    </asp:GridView>
</form>

