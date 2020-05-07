<%@ Page Language="C#" AutoEventWireup="true" CodeFile="add.aspx.cs" Inherits="add" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title></title>
    <style type="text/css">
        .auto-style1 {
            width: 503px;
            height: 470px;
        }
        .auto-style2 {
            width: 357px;
            height: 267px;
        }
    </style>
</head>
<body>
    <form id="form1" runat="server">
    <div>
        <asp:RadioButtonList ID="RadioButtonList2" runat="server" RepeatDirection="Horizontal" AutoPostBack="True" OnSelectedIndexChanged="RadioButton2_SelectedIndexChanged">
            <asp:ListItem>视图1</asp:ListItem>
            <asp:ListItem>视图2</asp:ListItem>
            <asp:ListItem>视图3</asp:ListItem>
            <asp:ListItem>视图4</asp:ListItem>
        </asp:RadioButtonList>            
        <asp:MultiView ID="MultiView1" runat="server" ActiveViewIndex="0" EnableViewState="False" OnActiveViewChanged="MultiView1_ActiveViewChanged">
            <asp:View ID="View1" runat="server">
                  <div>
        <asp:FileUpload ID="FileUpload1" runat="server" />
        <asp:Button ID="Button1" runat="server" OnClick="Button1_Click" Text="文件上传" />     
    </div>
        <asp:Literal ID="Literal1" runat="server"></asp:Literal>
                  <asp:LinkButton ID="LinkButton1" runat="server" CommandArgument="View4" CommandName="SwitchViewByID">回尾视图</asp:LinkButton>
                  <asp:LinkButton ID="LinkButton2" runat="server" CommandName="NextView">下一视图</asp:LinkButton>
            </asp:View>
             <asp:View ID="View2" runat="server">
                 <img class="auto-style2" src="sucai/Jellyfish.jpg" />
                 <asp:LinkButton ID="LinkButton3" runat="server" CommandName="PrevView">上一视图</asp:LinkButton>
                 <asp:LinkButton ID="LinkButton4" runat="server" CommandName="NextView">下一视图</asp:LinkButton>
            </asp:View>
             <asp:View ID="View3" runat="server">
                  <asp:Wizard ID="Wizard1" runat="server" BackColor="#E6E2D8" BorderColor="#999999" BorderStyle="Solid" BorderWidth="1px" Font-Names="Verdana" Font-Size="Large" ActiveStepIndex="0" HeaderText="欢迎注册本网站" Height="228px" OnFinishButtonClick="Wizard1_FinishButtonClick" Width="507px" OnActiveStepChanged="Wizard1_ActiveStepChanged">
            <HeaderStyle BackColor="Blue" BorderColor="#E6E2D8" BorderStyle="Groove" BorderWidth="2px" Font-Bold="True" Font-Size="0.9em" ForeColor="White" HorizontalAlign="Center" />
            <NavigationButtonStyle BackColor="#6699FF" BorderColor="#C5BBAF" BorderStyle="Solid" BorderWidth="1px" Font-Names="Verdana" Font-Size="0.8em" ForeColor="#1C5E55" />
                      <NavigationStyle BackColor="#CCFFFF" />
            <SideBarButtonStyle ForeColor="White" BackColor="Blue" BorderColor="White" />
            <SideBarStyle BackColor="Blue" Font-Size="0.9em" VerticalAlign="Top" />
            <StepStyle BackColor="#F7F6F3" BorderColor="#E6E2D8" BorderStyle="Solid" BorderWidth="2px" />
            <WizardSteps>
                <asp:WizardStep runat="server" title="基本信息">
                    用户名：<asp:TextBox ID="txtName" runat="server" Width="119px"></asp:TextBox>
                    <br />
                    密&nbsp;&nbsp; 码：<asp:TextBox ID="txtPwd" runat="server" TextMode="Password" Width="117px"></asp:TextBox>
                </asp:WizardStep>
                <asp:WizardStep runat="server" title="详细信息">
                    所在省份：<asp:DropDownList ID="ddlPro" runat="server" Width="75px">
                        <asp:ListItem>安徽</asp:ListItem>
                        <asp:ListItem>浙江</asp:ListItem>
                        <asp:ListItem>上海</asp:ListItem>
                        <asp:ListItem>江苏</asp:ListItem>
                        <asp:ListItem>其他</asp:ListItem>
                    </asp:DropDownList>
                    <br />
                    电话号码：<asp:TextBox ID="txtTel" runat="server" Width="70px"></asp:TextBox>
                    <br />
                    性别：<asp:RadioButtonList ID="RadioButtonList1" runat="server" RepeatDirection="Horizontal" Width="101px">
                        <asp:ListItem>男</asp:ListItem>
                        <asp:ListItem>女</asp:ListItem>
                    </asp:RadioButtonList>
                </asp:WizardStep>
                <asp:TemplatedWizardStep runat="server" Title="兴趣爱好" ID="mb">
                    <ContentTemplate>
                    <asp:CheckBoxList ID="chk1Likes" runat="server" RepeatColumns="3" RepeatDirection="Horizontal" Width="237px">
                        <asp:ListItem>游戏</asp:ListItem>
                        <asp:ListItem>运动</asp:ListItem>
                        <asp:ListItem>读书</asp:ListItem>
                        <asp:ListItem>料理</asp:ListItem>
                        <asp:ListItem>酒吧</asp:ListItem>
                        <asp:ListItem>其他</asp:ListItem>
                    </asp:CheckBoxList>
                        </ContentTemplate>
                </asp:TemplatedWizardStep>
                <asp:WizardStep runat="server" Title="会员等级">
                    <asp:DropDownList ID="DropDownList2" runat="server">
                        <asp:ListItem>普通会员</asp:ListItem>
                        <asp:ListItem>高级会员</asp:ListItem>
                        <asp:ListItem>至尊会员</asp:ListItem>
                    </asp:DropDownList>
                </asp:WizardStep>
                <asp:WizardStep runat="server" StepType="Complete" Title="完成">
                    注册成功：您的注册信息如下，请牢记！<br />用户名：<asp:Label ID="lblName" runat="server" Text=""></asp:Label>
                    <br />
                    密码：<asp:Label ID="lblPwd" runat="server" Text=""></asp:Label>
                    <br />
                    性别：<asp:Label ID="lblsex" runat="server" Text="Label"></asp:Label>
                    <br />
                    <asp:Label ID="lblPro" runat="server" Text=""></asp:Label>
                    <br />
                    <asp:Label ID="lblTel" runat="server" Text=""></asp:Label>
                    <br />
                    您选择了以下兴趣：<br />
                    <asp:PlaceHolder ID="ph" runat="server"></asp:PlaceHolder>
                </asp:WizardStep>
            </WizardSteps>
        </asp:Wizard>
                  <asp:LinkButton ID="LinkButton5" runat="server" CommandName="PrevView">上一视图</asp:LinkButton>
                  <asp:LinkButton ID="LinkButton6" runat="server" CommandName="NextView">下一视图</asp:LinkButton>
            </asp:View>
             <asp:View ID="View4" runat="server">
                 &nbsp;<img class="auto-style1" src="sucai/Lighthouse.jpg" /><asp:LinkButton ID="LinkButton9" runat="server" CommandName="PrevView">上一视图</asp:LinkButton> 
               <asp:LinkButton ID="LinkButton8" runat="server" CommandArgument="View1" CommandName="SwitchViewByID">回首视图</asp:LinkButton> 
            </asp:View>
        </asp:MultiView>  
    </div>
    </form>
</body>
</html>
