<%@ page import="java.util.Calendar" %><%@
    page import="com.boletobancario.boleto.pdf.BoletoPDFFormatter" %><%@
    page import="com.boletobancario.boleto.BoletoFactory" %><%
    
    //http://www.boletobancario.com/onlinedemo/
        
    // Gera um boleto em formato PDF, o boleto й personalizado utilizando dados estбticos.
    // Na aplicaзгo real os dados devem ser atribuнdos dinamicamente.
    
    BoletoFactory factory = new BoletoFactory();
    
    factory.setBanco( BoletoFactory.BRADESCO );
    factory.setAgencia( "123" );
    factory.setCodBeneficiario( "4567" );
    factory.setCarteira( "06" );
    factory.setNossoNumero( "378" );
    factory.setValor( "54,00" );
    factory.setVencimento( Calendar.getInstance() );
    
    factory.setLocalPagamento( "Pagбvel em qualquer agкncia bancбria atй o vencimento." );
    
    factory.setNomeBeneficiario( "Empresa Demonstraзгo LTDA." );
    factory.setCpfCnpjBeneficiario( "11.222.333/4444-55" );
    factory.setEnderecoBeneficiario( "Av. Alberto Santos-Dumont, 567" );
    factory.setCepBeneficiario( "75400-820" );
    factory.setCidadeBeneficiario( "Curitiba" );
    factory.setEstadoBeneficiario( "PR" );
    
    factory.setNomePagador( "Beltrano de Tal" );
    factory.setCpfCnpjPagador( "777.999.333-88" );
    factory.setEnderecoPagador( "R. Silas Salazar, 768 - 8є Andar" );
    factory.setCepPagador( "12345678" );
    factory.setCidadePagador( "Sгo Paulo" );
    factory.setEstadoPagador( "SP" );
    
    factory.setMensagem( 1, "Apуs o vencimento, entre em contato com nossa central de atendimento." );
    factory.setMensagem( 9, "[b]Sr. Caixa: Boleto Demonstrativo. Nгo receber.[/b] Gerado por: [b]www.boletobancario.com[/b]" );
    factory.setAceite( "Nгo" );
    
    String custom = "imageC63:cabecalho.png|nl:1|";
           custom += "textBC20: |nl:1|";
           custom += "textBC16:Fatura mensal de serviзos|nl:3|";
           custom += "textBL12:Descritivo dos serviзos|nl:2|";
           custom += "tab:2|textNL11:* Quantidade contratada: 100 - |textBL11: R$ 20,00|nl:1|";
           custom += "tab:2|textNL11:* Quantidade excedente: 150 - |textBL11: R$ 40,00|nl:2|";
           custom += "tab:2|textNL11:* Desconto fidelidade: 14 Meses - |textBL11: 10% - (R$ 6,00)|nl:3|";
           custom += "textNL12:Total desta fatura:|textBL12: R$ {valor}|nl:4|";
           custom += "textNL10:Prezado {pagador.primeiro-nome}, verificamos que seu consumo excedeu em mais de 20% o plano contratado.|nl:1|";
           custom += "textNL10:Vocк pode alterar seu plano na бrea restrita de nosso site: |textBL10:www.boletobancario.com|";
           custom += "rect:0.5,10,450,575,0.5|";
           custom += "color:200,10,10|";
           custom += "rect:1,120,557,55,18|";
    
    factory.setCustomContent( custom );
    
    response.setContentType( "application/x-pdf" );
    response.setHeader( "Pragma", "public" );
    response.setHeader( "Cache-Control", "max-age=0" );
    response.setHeader( "Content-Disposition", "attachment; filename=\"boleto.pdf\"" );
    
    new BoletoPDFFormatter(factory.createBoleto(), BoletoPDFFormatter.LAYOUT_NORMAL, response.getOutputStream() ).format();
%>