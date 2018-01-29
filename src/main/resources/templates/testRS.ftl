<html >
<head>
	<meta charset="UTF-8"></meta>
	<title>基因检测报告</title>
    <style type="text/css">
        #a1{
            font-size: 15px;
        }
        #title_text{
            font-family:  verdana,arial,sans-serif;
            font-style: normal;
            color: burlywood;
        }
        #sm{
            line-height: 18px;
            letter-spacing: 1px;
            font-family:verdana,arial,sans-serif;
        }
        ul{
            font-size: 15px;
        }
        table{
        }
        /* Border styles */
        #table-1 thead, #table-1 tr {
            border-top-width: 1px;
            border-top-style: solid;
            border-top-color: rgb(230, 189, 189);
        }
        #table-1 {
            border-bottom-width: 1px;
            border-bottom-style: solid;
            border-bottom-color: rgb(230, 189, 189);
        }

        /* Padding and font style */
        #table-1 td, #table-1 th {
            padding: 5px 10px;
            font-size: 12px;
            font-family: Verdana;
            color: rgb(177, 106, 104);
        }

        /* Alternating background colors */
        #table-1 tr:nth-child(even) {
            background: rgb(238, 211, 210)
        }
        #table-1 tr:nth-child(odd) {
            background: #FFF
        }
        table.gridtable {
            font-family: verdana,arial,sans-serif;
            font-size:11px;
            color:#333333;
            border-width: 1px;
            border-color: #666666;
            border-collapse: collapse;
            padding-top: 1px;
            background: bisque;
        }
        table.gridtable th {
            border-width: 1px;
            padding: 8px;
            border-style: solid;
            border-color: #666666;
            background-color: burlywood;
        }
        table.gridtable td {
            border-width: 1px;
            height: 100px;
            padding: 2px;
            border-style: solid;
            border-color: #666666;
            background-color: #ffffff;
        }
        table.gridtable caption{
            text-align:left;
            padding-bottom:0;
            border-style: none;
        }


        table.infotable{
            border-width: 1px;
            padding: 8px;
            border-collapse: collapse;
            border-style: solid;
            border-color: #666666;
            background-color: burlywood;
            font-family: verdana,arial,sans-serif;
        }
        table.QCtable{
            border-width: 1px;
            padding: 4px;
            border-collapse: collapse;
            border-style: solid;
            border-color: #666666;
            font-size: 12px;
            font-family: verdana,arial,sans-serif;
        }
        table.QCtable th{
            background-color: burlywood;
        }


    </style>

</head>
<body>

<h1 id="title_text">基因检测报告</h1>
<br>
<br>
         <table_title > 患者信息</table_title>
		 <table  class="infotable" width="600">
                 <strong id="a1">姓名:&nbsp;&nbsp;&nbsp;</strong><a class="a2" >${Patientname}</a><br>
                 <strong id="a1">年龄:&nbsp;&nbsp;&nbsp;</strong><a class="a2">${PatientAge}</a><br>
                 <strong id="a1">性别:&nbsp;&nbsp;&nbsp;</strong><a class="a2">${PatientSex}</a><br>

		 </table>
<br>
<br>

         <table_title > 化疗药物</table_title>
		 <table  class="gridtable" width="600" border="1">
			 <tr>
				 <th align="left">疾病</th>
                 <th align="left" >药物</th>
                 <th align="left">基因</th>
                 <th align="left">rs</th>
                 <th align="left" >证据等级</th>
                 <th align="left">基因型</th>
                 <th align="left ">注释</th>
			 </tr>
             <#if ChemotherapyList?exists>
				 <#list ChemotherapyList as item>
		     <tr>
                 <td>${item.mDisease}</td>
                 <td>${item.mDrug}</td>
                 <td>${item.mGene}</td>
                 <td>${item.mRS}</td>
                 <td>${item.mEvidenceLevel}</td>
                 <td>${item.mGenotype}</td>
                 <td>${item.mAnnotation}</td>
             </tr>
				 </#list>
			 </#if>
		 </table>


<h4>原始测序数据质控</h4>
<table_title > 测序数据质控</table_title>
<table  class="QCtable" width="600" border="1">
    <tr>

        <th align="left"></th>
        <th align="left">癌组织</th>
        <th align="left" >对照组</th>
    </tr>
     <tr>
         <td>数据量</td>
         <td>${QcDatas.mCancerDatasSize}</td>
         <td>${QcDatas.mControlDataSize}</td>
     </tr>
    <tr>
        <td>比对上序列</td>
        <td>${QcDatas.mCancerMapped}</td>
        <td>${QcDatas.mControlMapped}</td>
    </tr>
    <tr>
        <td>目标区域大小</td>
        <td>${QcDatas.mCancerTargetRegion}</td>
        <td>${QcDatas.mControlTargetRegion}</td>
    </tr>
    <tr>
        <td>有效</td>
        <td>${QcDatas.mCancerTotalEffectiveYield}</td>
        <td>${QcDatas.mControlTotalEffectiveYield}</td>
    </tr>
    <tr>
        <td>目标序列有效</td>
        <td>${QcDatas.mCancerEffectiveYieldOnTarget}</td>
        <td>${QcDatas.mControlEffectiveYieldOnTarget}</td>
    </tr>
    <tr>
        <td>覆盖度</td>
        <td>${QcDatas.mCancerCoverage}</td>
        <td>${QcDatas.mControlCoverage}</td>
    </tr>
    <tr>
        <td>平均深度</td>
        <td>${QcDatas.mCancerAverageSequenceDepths}</td>
        <td>${QcDatas.mControlAverageSequenceDepths}</td>
    </tr>

</table>

</body>
</html>