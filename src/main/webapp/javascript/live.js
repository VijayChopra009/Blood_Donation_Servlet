

let input = document.getElementById('live');
input.style.display = 'none';

let apikey = '2ae09182a68afc5e13f06adcc56a02f5';
let part = 'current';

async function getdata(lat, long) {
    const promise = await fetch(`https://nominatim.openstreetmap.org/reverse?format=json&lat=${lat}&lon=${long}`)
    return await promise.json();
}

async function getlocation(position) {
    const result = await getdata(position.coords.latitude, position.coords.longitude);
    console.log(result)
    input.value = result.display_name;
}

function failedtoget() {
    alert("Failed to get the location some error occured!")
}

//automatically load the function when user get to this page
window.addEventListener('load', async () => {
    navigator.geolocation.getCurrentPosition(getlocation, failedtoget);
});
;