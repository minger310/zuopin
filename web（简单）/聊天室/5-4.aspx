<%@ Page Language="C#" AutoEventWireup="true" CodeFile="5-4.aspx.cs" Inherits="_5_4" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title></title>
</head>
<body>
    <form id="form1" runat="server">
    <div>
    
        用户ID:<asp:TextBox ID="TextBox1" runat="server"></asp:TextBox>
        <br />
        昵称:<asp:TextBox ID="TextBox2" runat="server"></asp:TextBox>
        <br />
        <asp:Button ID="Button1" runat="server" OnClick="Button1_Click" Text="页面跳转并地址栏传值" />
    
    </div>
    </form>
</body>
</html>
