async function postCommentToServer(cmtData){
	try{
		const url = "/cmt/post";
		const config = {
			method: 'post',
			headers: {
				'content-Type': 'application/json; charset=utf-8'
			},
			body: JSON.stringify(cmtData)
		};
		const resp = await fetch(url, config);
		const result = await resp.text();
		return result;
	}catch(error){
		console.log(error);
	}
}




document.getElementById('cmtAddBtn').addEventListener('click', function(){
	const cmtText = document.getElementById('cmtText').value;
	if(cmtText == null || cmtText == ""){
		alert('댓글을 입력해주세요.');
		return false;
	} else{
		let cmtData = {
			bno: bnoVal,
			writer: document.getElementById('cmtWriter').value,
			content: cmtText
		};
		postCommentToServer(cmtData).then(result=>{
			if(result>0){
				alert('댓글 등록 성공');
				document.getElementById('cmtText').value="";
			}
			printCommentList(cmtData.bno);
		})
	}
})