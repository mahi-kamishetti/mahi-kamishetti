document.getElementById('voteForm').addEventListener('submit', async function(event) {
    event.preventDefault(); // Prevent the default form submission

    const selectedCandidate = document.querySelector('input[name="candidate"]:checked');

    if (selectedCandidate) {
        const candidateValue = selectedCandidate.value;

        try {
            const response = await fetch('/submit-vote', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify({ candidate: candidateValue }),
            });

            if (response.ok) {
                document.getElementById('responseMessage').innerText = 'Vote submitted successfully!';
                document.getElementById('voteForm').reset(); // Clear the form
            } else {
                throw new Error('Failed to submit vote.');
            }
        } catch (error) {
            document.getElementById('responseMessage').innerText = 'Error: ' + error.message;
        }
    } else {
        document.getElementById('responseMessage').innerText = 'Please select a candidate.';
    }
});
