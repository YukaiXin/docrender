<html >
<head>
	<meta charset="UTF-8"></meta>
	<title>基因检测报告</title>
    <link href="C:/Users/ykx/codes/demo/src/main/resources/CSS/tablestyle.css" rel="stylesheet">
    <link href="C:/Users/ykx/codes/demo/src/main/resources/CSS/custom-styles.css" rel="stylesheet">
    <style type="text/css">

    </style>

</head>
<body>

<h1 id="title_text">基因检测报告</h1>
<br>
<br>
         <table_title > 患者信息1</table_title>
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
             <#if userList?exists>
				 <#list userList as item>
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

<br>
<br>
<div id="sm">
<h4>注解：</h4>
<h4>临床证据级别，作为临床指导参考</h4>
<h5>Level 1A：存在于临床指南或者专家共识；</h5>
<h5>Level 1B：基因型与药效关联在多项临床研究中统计学显著；</h5>
<h5>Level 2A：基因型与药效关联基于多项临床研究。故药效关系可能有意义；</h5>
<h5>Level 2B：基因型与药效关联基于多项临床研究，但部分研究统计学不显著。</h5>
<h5>Level 3: 基因型与药效关联来自于单项研究，无重复结果；或者多项研究但缺乏明显药效关联性；结果仅供参考，不作为临床依据。</h5>
<h5>n.a．未能有效检测</h5>
<br>
<br>
<br>
<h4>参考文献</h4>
<h5>1. PharmGKB基因型-药效关系数据库：<a href="https://www.pharmgkb.org/">https://www.pharmgkb.org/</a></h5>
<br>
<br>
<br>
<h4>免责声明</h4>
<ul>
    <li>此分析报告主要提供送检样品中肿瘤相关基因的变异情况，所得结论来自于目前世界上最前沿的科学进展与分析算法，本公司承诺尽力实现检测结果与分析结论的精准性，但报告中出现的任何结论不涉及与任何药物治疗效果的必然联系，因此本报告不承诺某种药物治疗的有效或无效性，医生根据此份报告选择药物进而产生的一切不良反应或影响，本公司不予赔偿，并不承诺其他第三方机构的赔偿。</li>

    <li>报告中变异与异常通路的分析注释不按照先后顺序排名。</li>

    <li>分析报告提及的用药注释及推荐不会对所有患者均适用，患者的病史、家族史、体检报告、其他医学检测信息等都有可能对最佳治疗决策与治疗效果产生影响，任何治疗方案的选取都应由医生综合报告与患者的其他信息后决定。分析报告不能替代医嘱或正式治疗方案使用。</li>

    <li>本公司对以上检测结果与分析内容保留最终解释权。</li>
</ul>
</div>
<br>
<h3>附加信息</h3>
<h4>附件 1 – 数据质量控制</h4>
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
         <td>${QC.mCancerDatasSize}</td>
         <td>${QC.mControlDataSize}</td>
     </tr>
    <tr>
        <td>比对上序列</td>
        <td>${QC.mCancerMapped}</td>
        <td>${QC.mControlMapped}</td>
    </tr>
    <tr>
        <td>目标区域大小</td>
        <td>${QC.mCancerTargetRegion}</td>
        <td>${QC.mControlTargetRegion}</td>
    </tr>
    <tr>
        <td>有效</td>
        <td>${QC.mCancerTotalEffectiveYield}</td>
        <td>${QC.mControlTotalEffectiveYield}</td>
    </tr>
    <tr>
        <td>目标序列有效</td>
        <td>${QC.mCancerEffectiveYieldOnTarget}</td>
        <td>${QC.mControlEffectiveYieldOnTarget}</td>
    </tr>
    <tr>
        <td>覆盖度</td>
        <td>${QC.mCancerCoverage}</td>
        <td>${QC.mControlCoverage}</td>
    </tr>
    <tr>
        <td>平均深度</td>
        <td>${QC.mCancerAverageSequenceDepths}</td>
        <td>${QC.mControlAverageSequenceDepths}</td>
    </tr>

</table>

</body>
</html>